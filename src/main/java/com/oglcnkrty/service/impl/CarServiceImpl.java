package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.DtoCar;
import com.oglcnkrty.dto.DtoCarIU;
import com.oglcnkrty.model.Car;
import com.oglcnkrty.repository.CarRepository;
import com.oglcnkrty.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    CarRepository carRepository;

    private Car createCar(DtoCarIU dtoCarIU) {
        Car car = new Car();
        car.setCreationDate(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(dtoCarIU));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}
