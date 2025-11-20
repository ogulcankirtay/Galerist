package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoGaleristCar;
import com.oglcnkrty.dto.DtoGaleristCarIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestGaleristCarController {

    public RootEntity<DtoGaleristCar> saveGaleristCar(DtoGaleristCarIU dtoGaleristCarIU);
}
