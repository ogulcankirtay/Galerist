package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoGalerist;
import com.oglcnkrty.dto.DtoGaleristIU;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.model.Address;
import com.oglcnkrty.model.Galerist;
import com.oglcnkrty.repository.AddressRepository;
import com.oglcnkrty.repository.GaleristRepository;
import com.oglcnkrty.service.IGaleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GaleristServiceImpl implements IGaleristService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    GaleristRepository galeristRepository;

    private Galerist createGalerist(DtoGaleristIU dtoGaleristIU) {
        Galerist galerist = new Galerist();
        Address address = new Address();


        Optional<Address> otpAddress = addressRepository.findById(dtoGaleristIU.getAddressId());

        if (otpAddress.isEmpty()) {
            throw new BaseException(
                    new ErrorMessage(ErrorType.NO_RECORD_EXISTS,
                            dtoGaleristIU.getAddressId().toString()));
        }

        BeanUtils.copyProperties(otpAddress.get(), address);
        BeanUtils.copyProperties(dtoGaleristIU, galerist);
        galerist.setAddress(address);
        galerist.setCreationDate(new Date());

        return galerist;
    }

    @Override
    public DtoGalerist saveGalerist(DtoGaleristIU dtoGaleristIU) {
        DtoGalerist dtoGalerist = new DtoGalerist();
        DtoAddress address = new DtoAddress();

        Galerist savedGalerist = galeristRepository.save(createGalerist(dtoGaleristIU));

        BeanUtils.copyProperties(savedGalerist, dtoGalerist);
        BeanUtils.copyProperties(savedGalerist.getAddress(), address);
        dtoGalerist.setAddress(address);

        return dtoGalerist;
    }
}
