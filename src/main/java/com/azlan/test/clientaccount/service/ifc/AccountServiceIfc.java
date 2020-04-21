package com.azlan.test.clientaccount.service.ifc;

import com.azlan.test.clientaccount.model.entity.AccountEntity;

import java.util.List;


public interface AccountServiceIfc {

    Iterable<AccountEntity> getAllAccounts();

    List<AccountEntity> getAccountByClientId(Long clientId);

    void addAccount(AccountEntity account);
}
