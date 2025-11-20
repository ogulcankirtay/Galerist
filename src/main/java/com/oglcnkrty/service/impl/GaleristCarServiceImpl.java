package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.*;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.model.Address;
import com.oglcnkrty.model.Car;
import com.oglcnkrty.model.Galerist;
import com.oglcnkrty.model.GaleristCar;
import com.oglcnkrty.repository.CarRepository;
import com.oglcnkrty.repository.GaleristCarRepository;
import com.oglcnkrty.repository.GaleristRepository;
import com.oglcnkrty.service.IGaleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GaleristCarServiceImpl implements IGaleristCarService {

    @Autowired
    private GaleristCarRepository galeristCarRepository;
    @Autowired
    private GaleristRepository galeristRepository;
    @Autowired
    private CarRepository carRepository;

    private GaleristCar createCarGalerist(DtoGaleristCarIU dtoGaleristCarIU) {
        GaleristCar galeristCar = new GaleristCar();

        Optional<Galerist> optGalerist = galeristRepository.findById(dtoGaleristCarIU.getGaleristId());
        if (optGalerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS,
                    dtoGaleristCarIU.getGaleristId().toString()));
        }

        Optional<Car> optCar = carRepository.findById(dtoGaleristCarIU.getCarId());
        if (optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS,
                    dtoGaleristCarIU.getCarId().toString()));
        }

        galeristCar.setCreationDate(new Date());
        galeristCar.setCar(optCar.get());
        galeristCar.setGalerist(optGalerist.get());

        return galeristCar;
    }

    @Override
    public DtoGaleristCar saveGaleristCar(DtoGaleristCarIU dtoGaleristCarIU) {
        DtoGalerist dtoGalerist = new DtoGalerist();
        DtoCar dtoCar = new DtoCar();
        DtoGaleristCar dtoGaleristCar = new DtoGaleristCar();
        DtoAddress dtoAddress = new DtoAddress();

        GaleristCar savedGaleristCar = galeristCarRepository.save(createCarGalerist(dtoGaleristCarIU));

        BeanUtils.copyProperties(savedGaleristCar, dtoGaleristCar);
        BeanUtils.copyProperties(savedGaleristCar.getCar(), dtoCar);
        BeanUtils.copyProperties(savedGaleristCar.getGalerist(), dtoGalerist);
        BeanUtils.copyProperties(savedGaleristCar.getGalerist().getAddress(), dtoAddress);

        dtoGaleristCar.setDtoCar(dtoCar);
        dtoGalerist.setAddress(dtoAddress);
        dtoGaleristCar.setDtoGalerist(dtoGalerist);

        return dtoGaleristCar;
    }
}
