package com.oglcnkrty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrencyRateResponse {

    private Integer totalCount;

    private List<CurrencyRateItems> items;
}
