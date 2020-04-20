package com.azlan.test.clientaccount.repository;

import com.azlan.test.clientaccount.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findAccountByClientId(Long clientId);
}
