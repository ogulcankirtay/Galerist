package com.oglcnkrty.controller;

import com.oglcnkrty.dto.CurrencyRateResponse;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.model.CurrencyRateRequest;

public interface IRestCurrencyRatesController {

    public RootEntity<CurrencyRateResponse> getCurrencyRates(CurrencyRateRequest currencyRateRequest);

}
