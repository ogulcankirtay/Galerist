package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestCurrencyRatesController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.CurrencyRateResponse;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.model.CurrencyRateRequest;
import com.oglcnkrty.service.ICurrencyRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController {
    @Autowired
    private ICurrencyRateService currencyRateService;

    @GetMapping("/currency_rate")
    @Override
    public RootEntity<CurrencyRateResponse> getCurrencyRates(@RequestBody CurrencyRateRequest currencyRateRequest) {
        return ok(currencyRateService.getCurrencyRates(currencyRateRequest));
    }
}
