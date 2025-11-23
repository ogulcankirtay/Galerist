package com.oglcnkrty.service;

import com.oglcnkrty.dto.CurrencyRateItems;
import com.oglcnkrty.dto.CurrencyRateResponse;
import com.oglcnkrty.model.CurrencyRateRequest;

public interface ICurrencyRateService {

    public CurrencyRateResponse getCurrencyRates(CurrencyRateRequest currencyRateRequest);
}
