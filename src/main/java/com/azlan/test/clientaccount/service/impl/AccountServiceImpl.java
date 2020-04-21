package com.azlan.test.clientaccount.service.impl;

import com.azlan.test.clientaccount.model.entity.AccountEntity;
import com.azlan.test.clientaccount.repository.AccountRepository;
import com.azlan.test.clientaccount.service.ifc.AccountServiceIfc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountServiceIfc {

    @Autowired
    private AccountRepository accountRepository;

    public Iterable<AccountEntity> getAllAccounts(){

        return accountRepository.findAll();
    }

    public List<AccountEntity> getAccountByClientId(Long clientId){

        return accountRepository.findAccountByClientId(clientId);
    }

    public void addAccount(AccountEntity account){
        accountRepository.save(account);
    }

}
