package com.oglcnkrty.dto;

import com.oglcnkrty.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoAccountIU {
    private String accountNumber;

    private String iban;

    private BigDecimal amount;

    private CurrencyType currency;
}
