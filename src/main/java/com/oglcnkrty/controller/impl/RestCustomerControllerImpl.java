package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestCustomerController;
import com.oglcnkrty.controller.RestBaseController;
import com.oglcnkrty.dto.DtoCustomer;
import com.oglcnkrty.dto.DtoCustomerIU;
import com.oglcnkrty.dto.RootEntity;
import com.oglcnkrty.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
