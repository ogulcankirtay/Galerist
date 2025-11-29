package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoSoledCar;
import com.oglcnkrty.dto.DtoSoledCarIU;

public interface ISoledCarService {

    public DtoSoledCar buy(DtoSoledCarIU dtoSoledCarIU);
}
