package com.oglcnkrty.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGaleristCar extends DtoBase {

    DtoCar dtoCar;

    DtoGalerist DtoGalerist;
}
