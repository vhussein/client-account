package com.azlan.test.clientaccount.service.ifc;

import com.azlan.test.clientaccount.model.entity.AccountEntity;

import java.util.Optional;


public interface AccountServiceIfc {

    Iterable<AccountEntity> getAllAccounts();

    Optional<AccountEntity> getAccount(Long accountId);

    void addAccount(AccountEntity account);
}
