package com.oglcnkrty.service;

import com.oglcnkrty.dto.DtoAccount;
import com.oglcnkrty.dto.DtoAccountIU;
import com.oglcnkrty.model.Account;
import com.oglcnkrty.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {
        Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));

        DtoAccount dtoAccount = new DtoAccount();
        BeanUtils.copyProperties(savedAccount, dtoAccount);

        return dtoAccount;
    }

    private Account createAccount(DtoAccountIU dtoAccountIU) {
        Account account = new Account();

        account.setCreationDate(new Date());
        BeanUtils.copyProperties(dtoAccountIU, account);

        return account;
    }
}
