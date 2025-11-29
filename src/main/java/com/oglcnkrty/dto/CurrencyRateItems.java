package com.oglcnkrty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyRateItems {

    @JsonProperty("Tarih")
    private String date;

    @JsonProperty("TP_DK_USD_A_YTL")
    private BigDecimal usd;
}
