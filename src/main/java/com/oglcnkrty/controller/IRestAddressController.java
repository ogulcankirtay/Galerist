package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoAddressIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveDtoAddress(DtoAddressIU dtoAddress);
}
