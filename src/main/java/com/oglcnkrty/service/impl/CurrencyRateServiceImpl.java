package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.CurrencyRateResponse;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.model.CurrencyRateRequest;
import com.oglcnkrty.service.ICurrencyRateService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRateServiceImpl implements ICurrencyRateService {
    @Override
    public CurrencyRateResponse getCurrencyRates(CurrencyRateRequest currencyRateRequest) {
        String rootUrl = "https://evds2.tcmb.gov.tr/service/evds/";
        String series = "TP.DK.USD.A.YTL";
        String type = "json";
        String endPoint = rootUrl + "series=" + series +
                "&startDate=" + currencyRateRequest.getStartDate() + "&endDate=" + currencyRateRequest.getEndDate() + "&type=" + type;
        HttpHeaders headers = new HttpHeaders();
        headers.set("key", "take_key_from_link");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<CurrencyRateResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, entity, new ParameterizedTypeReference<CurrencyRateResponse>() {
            });
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            } else {
                throw new BaseException(new ErrorMessage(ErrorType.CURRENCY_RATES_IS_OCCURRED, ""));
            }
        } catch (RestClientException e) {
            throw new BaseException(new ErrorMessage(ErrorType.CURRENCY_RATES_IS_OCCURRED, e.getMessage()));
        }
    }
}
