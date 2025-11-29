package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.*;
import com.oglcnkrty.enums.CarStatus;
import com.oglcnkrty.enums.CurrencyType;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.model.Car;
import com.oglcnkrty.model.CurrencyRateRequest;
import com.oglcnkrty.model.Customer;
import com.oglcnkrty.model.SoledCar;
import com.oglcnkrty.repository.CarRepository;
import com.oglcnkrty.repository.CustomerRepository;
import com.oglcnkrty.repository.GaleristRepository;
import com.oglcnkrty.repository.SoledCarRepository;
import com.oglcnkrty.service.ICurrencyRateService;
import com.oglcnkrty.service.ISoledCarService;
import com.oglcnkrty.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

@Service
public class SoledCarServiceImpl implements ISoledCarService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GaleristRepository galeristRepository;
    @Autowired
    private ICurrencyRateService currencyRateService;
    @Autowired
    private SoledCarRepository soledCarRepository;

    private BigDecimal convertAmountToUsd(BigDecimal amount) {

        String startDate = DateUtils.currentDate(new Date());
        String endDate = DateUtils.currentDate(new Date());
        CurrencyRateResponse rates = currencyRateService.getCurrencyRates(new CurrencyRateRequest(startDate, endDate));
        BigDecimal usd = rates.getItems().get(0).getUsd();
        return amount.divide(usd, 2, RoundingMode.HALF_UP);
    }

    private boolean checkAmount(DtoSoledCarIU dtoSoledCarIU) {
        Optional<Car> optCar = carRepository.findById(dtoSoledCarIU.getCarId());
        Optional<Customer> optCustomer = customerRepository.findById(dtoSoledCarIU.getCustomerId());
        BigDecimal carUsdAmount = BigDecimal.ZERO;
        BigDecimal customerUsdAmount = BigDecimal.ZERO;

        if (optCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS, dtoSoledCarIU.getCarId().toString()));
        }

        if (optCustomer.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS, dtoSoledCarIU.getCustomerId().toString()));
        }

        if (optCar.get().getCurrency().equals(CurrencyType.TL)) {
            carUsdAmount = convertAmountToUsd(optCar.get().getPrice());

        }

        if (optCustomer.get().getAccounts().get(0).getCurrency().equals(CurrencyType.TL)) {
            customerUsdAmount = convertAmountToUsd(optCustomer.get().getAccounts().get(0).getAmount());
        }

        if (customerUsdAmount.compareTo(carUsdAmount) == 0 || customerUsdAmount.compareTo(carUsdAmount) > 0) {
            return true;
        }
        return false;
    }

    private boolean checkCarStatus(Long carID) {
        Optional<Car> optionalCar = carRepository.findById(carID);
        if (optionalCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS, String.valueOf(carID)));
        }

        return optionalCar.get().getCarStatus().name().equals(CarStatus.SALABLE.name());
    }

    private SoledCar createCarObject(DtoSoledCarIU dtoSoledCarIU) {
        SoledCar soledCar = new SoledCar();
        soledCar.setCreationDate(new Date());

        soledCar.setCar(carRepository.findById(dtoSoledCarIU.getCarId()).orElse(null));
        soledCar.setCustomer(customerRepository.findById(dtoSoledCarIU.getCustomerId()).orElse(null));
        soledCar.setGalerist(galeristRepository.findById(dtoSoledCarIU.getGaleristId()).orElse(null));

        return soledCar;
    }

    private BigDecimal remainingCustomerMoney(Customer customer, Car car) {
        BigDecimal carUsdAmount = BigDecimal.ZERO;
        BigDecimal customerUsdAmount = BigDecimal.ZERO;

        if (car.getCurrency().equals(CurrencyType.TL)) {
            carUsdAmount = convertAmountToUsd(car.getPrice());

        }

        if (customer.getAccounts().get(0).getCurrency().equals(CurrencyType.TL)) {
            customerUsdAmount = convertAmountToUsd(customer.getAccounts().get(0).getAmount());
        }

        BigDecimal remainingMoney = customerUsdAmount.subtract(carUsdAmount);
        if (customer.getAccounts().get(0).getCurrency().equals(CurrencyType.TL)) {
            return convertAmountToUsd(remainingMoney);
        }

        return remainingMoney;
    }

    @Override
    public DtoSoledCar buy(DtoSoledCarIU dtoSoledCarIU) {
        if (!checkAmount(dtoSoledCarIU)) {
            throw new BaseException(new ErrorMessage(ErrorType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
        }

        if (!checkCarStatus(dtoSoledCarIU.getCarId())) {
            throw new BaseException(new ErrorMessage(ErrorType.THIS_CAR_SOLED, ""));
        }

        SoledCar savedSoledCar = soledCarRepository.save(createCarObject(dtoSoledCarIU));

        Car car = savedSoledCar.getCar();
        car.setCarStatus(CarStatus.SOLD);
        carRepository.save(car);

        Customer customer = savedSoledCar.getCustomer();
        customer.getAccounts().get(0).setAmount(remainingCustomerMoney(customer, car));
        customerRepository.save(customer);

        return toDto(savedSoledCar);
    }

    private DtoSoledCar toDto(SoledCar soledCar) {
        DtoSoledCar dtoSoledCar = new DtoSoledCar();
        DtoGalerist dtoGalerist = new DtoGalerist();
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoCar dtoCar = new DtoCar();

        BeanUtils.copyProperties(soledCar, dtoSoledCar);
        BeanUtils.copyProperties(soledCar.getCar(), dtoCar);
        BeanUtils.copyProperties(soledCar.getCustomer(), dtoCustomer);
        BeanUtils.copyProperties(soledCar.getGalerist(), dtoGalerist);

        dtoSoledCar.setCustomer(dtoCustomer);
        dtoSoledCar.setGalerist(dtoGalerist);
        dtoSoledCar.setCar(dtoCar);

        return dtoSoledCar;
    }
}
