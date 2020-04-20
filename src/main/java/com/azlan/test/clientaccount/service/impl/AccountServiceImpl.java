package com.azlan.test.clientaccount.service.impl;

import com.azlan.test.clientaccount.model.Account;
import com.azlan.test.clientaccount.repository.AccountRepository;
import com.azlan.test.clientaccount.service.ifc.AccountServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountServiceIfc {

    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts(){

        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(Long clientId){

        return accountRepository.findAccountByClientId(clientId);
    }

}
