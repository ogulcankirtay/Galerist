package com.oglcnkrty.controller.impl;

import com.oglcnkrty.controller.IRestAddressController;
import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoAddressIU;
import com.oglcnkrty.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class RestAddressControllerImpl implements IRestAddressController {
    @Autowired
    IAddressService addressService;

    @PostMapping("/save")
    @Override
    public DtoAddress saveDtoAddress(@Valid @RequestBody DtoAddressIU dtoAddress) {
        return addressService.saveAddress(dtoAddress);
    }
}
