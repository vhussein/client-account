package com.azlan.test.clientaccount.repository;

import com.azlan.test.clientaccount.model.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    Optional<AccountEntity> findAccountByClientId(Long clientId);
}
