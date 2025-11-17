package com.oglcnkrty.model;

import com.oglcnkrty.enums.CarStatus;
import com.oglcnkrty.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car extends BaseEntity {

    private String licensePlate;

    private String brand;

    private String model;

    private Date productionDate;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    private BigDecimal damagePrice;

    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;
}
