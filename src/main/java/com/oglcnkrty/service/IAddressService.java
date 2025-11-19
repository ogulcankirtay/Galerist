package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
