package com.oglcnkrty.service;


import com.oglcnkrty.dto.DtoGaleristCar;
import com.oglcnkrty.dto.DtoGaleristCarIU;

public interface IGaleristCarService {

    public DtoGaleristCar saveGaleristCar(DtoGaleristCarIU dtoGaleristCarIU);
}
