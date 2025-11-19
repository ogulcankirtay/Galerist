package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoGalerist;
import com.oglcnkrty.dto.DtoGaleristIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestGaleristController {

    public RootEntity<DtoGalerist> saveGalerist(DtoGaleristIU dtoGaleristIU);

}
