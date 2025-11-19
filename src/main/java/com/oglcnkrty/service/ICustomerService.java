package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoCustomer;
import com.oglcnkrty.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
