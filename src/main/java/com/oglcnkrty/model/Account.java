package com.oglcnkrty.model;

import com.oglcnkrty.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {

    private String accountNumber;

    private String iban;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
}
