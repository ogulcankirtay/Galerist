package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoAddressIU;
import com.oglcnkrty.model.Address;
import com.oglcnkrty.repository.AddressRepository;
import com.oglcnkrty.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU dtoAddressIU) {
        Address address = new Address();
        address.setCreationDate(new Date());
        BeanUtils.copyProperties(dtoAddressIU, address);
        return address;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {
        Address saved = addressRepository.save(createAddress(dtoAddressIU));

        DtoAddress dtoAddress = new DtoAddress();
        BeanUtils.copyProperties(saved, dtoAddress);
        return dtoAddress;
    }
}
