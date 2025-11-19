package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoAddressIU;

public interface IRestAddressController {

    public DtoAddress saveDtoAddress(DtoAddressIU dtoAddress);
}
