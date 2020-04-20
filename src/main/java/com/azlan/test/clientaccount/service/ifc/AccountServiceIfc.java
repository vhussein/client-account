package com.azlan.test.clientaccount.service.ifc;

import com.azlan.test.clientaccount.model.Account;

import java.util.Optional;


public interface AccountServiceIfc {

    Iterable<Account> getAllAccounts();

    Optional<Account> getAccount(Long accountId);
}
