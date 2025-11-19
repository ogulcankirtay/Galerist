package com.oglcnkrty.service.impl;

import com.oglcnkrty.dto.DtoAccount;
import com.oglcnkrty.dto.DtoAddress;
import com.oglcnkrty.dto.DtoCustomer;
import com.oglcnkrty.dto.DtoCustomerIU;
import com.oglcnkrty.enums.ErrorType;
import com.oglcnkrty.exception.BaseException;
import com.oglcnkrty.exception.ErrorMessage;
import com.oglcnkrty.model.Account;
import com.oglcnkrty.model.Address;
import com.oglcnkrty.model.Customer;
import com.oglcnkrty.repository.AccountRepository;
import com.oglcnkrty.repository.AddressRepository;
import com.oglcnkrty.repository.CustomerRepository;
import com.oglcnkrty.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AddressRepository addressRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
        Customer customer = new Customer();
        Address address = new Address();

        customer.setCreationDate(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);

        List<Account> accounts = accountRepository.findAllById(dtoCustomerIU.getAccountsId());
        Optional<Address> otpAddress = addressRepository.findById(dtoCustomerIU.getAddressId());

        if (accounts.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS, dtoCustomerIU.getAccountsId().toString()));
        }

        if (otpAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(ErrorType.NO_RECORD_EXISTS, dtoCustomerIU.getAddressId().toString()));
        }

        for (Account account : accounts) {
            Account newAccount = new Account();
            BeanUtils.copyProperties(account, newAccount);
            customer.getAccounts().add(newAccount);
        }

        BeanUtils.copyProperties(otpAddress.get(), address);
        customer.setAddress(address);

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU request) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        List<DtoAccount> dtoAccounts = new ArrayList<>();
        DtoAddress dtoAddress = new DtoAddress();
        Customer customer = createCustomer(request);
        customerRepository.save(customer);

        BeanUtils.copyProperties(customer, dtoCustomer);

        for (Account account : customer.getAccounts()) {
            DtoAccount dtoAccount = new DtoAccount();
            BeanUtils.copyProperties(account, dtoAccount);
            dtoAccounts.add(dtoAccount);
        }
        dtoCustomer.setAccounts(dtoAccounts);

        BeanUtils.copyProperties(customer.getAddress(), dtoAddress);
        dtoCustomer.setAddress(dtoAddress);


        return dtoCustomer;
    }
}
