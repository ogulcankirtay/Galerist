package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoCar;
import com.oglcnkrty.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
