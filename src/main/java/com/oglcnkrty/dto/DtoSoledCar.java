package com.oglcnkrty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoSoledCar {

    private DtoCar car;

    private DtoCustomer customer;

    private DtoGalerist galerist;
}
