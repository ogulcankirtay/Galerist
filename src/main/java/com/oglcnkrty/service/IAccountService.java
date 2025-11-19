package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoAccount;
import com.oglcnkrty.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
