package com.oglcnkrty.controller;

import com.oglcnkrty.dto.DtoCustomer;
import com.oglcnkrty.dto.DtoCustomerIU;
import com.oglcnkrty.dto.RootEntity;

public interface IRestCustomerController {
    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
