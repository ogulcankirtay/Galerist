package com.oglcnkrty.dto;

import com.oglcnkrty.enums.CarStatus;
import com.oglcnkrty.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCar extends DtoBase {


    private String licensePlate;

    private String brand;

    private String model;

    private Date productionDate;

    private BigDecimal price;

    private CurrencyType currency;

    private BigDecimal damagePrice;

    private CarStatus carStatus;
}
