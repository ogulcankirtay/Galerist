package com.oglcnkrty.controller;

import com.oglcnkrty.dto.*;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
