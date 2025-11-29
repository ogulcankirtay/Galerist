package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoSoledCar;
import com.oglcnkrty.dto.DtoSoledCarIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestSoledCarController {

    public RootEntity<DtoSoledCar> buy(DtoSoledCarIU dtoSoledCarIU);
}
