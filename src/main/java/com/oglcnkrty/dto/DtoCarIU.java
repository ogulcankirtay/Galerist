package com.oglcnkrty.dto;

import com.oglcnkrty.enums.CarStatus;
import com.oglcnkrty.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCarIU {

    @NotNull
    private String licensePlate;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private Date productionDate;

    @NotNull
    private BigDecimal price;

    @NotNull
    private CurrencyType currency;

    @NotNull
    private BigDecimal damagePrice;

    @NotNull
    private CarStatus carStatus;
}
