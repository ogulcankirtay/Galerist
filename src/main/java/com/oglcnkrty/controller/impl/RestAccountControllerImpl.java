package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestAccountController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.*;
import com.oglcnkrty.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class RestAccountControllerImpl extends RestBaseController implements IRestAccountController {
    @Autowired
    IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
        return ok(accountService.saveAccount(dtoAccountIU));
    }
}
