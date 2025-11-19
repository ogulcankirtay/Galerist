package com.oglcnkrty.service;


import com.oglcnkrty.dto.DtoGalerist;
import com.oglcnkrty.dto.DtoGaleristIU;

public interface IGaleristService {

    public DtoGalerist saveGalerist(DtoGaleristIU dtoGaleristIU);
}
