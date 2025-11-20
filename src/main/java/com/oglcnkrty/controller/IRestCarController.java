package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoCar;
import com.oglcnkrty.dto.DtoCarIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestCarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
