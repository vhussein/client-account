package com.azlan.test.clientaccount.repository;

import com.azlan.test.clientaccount.model.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {

    List<AccountEntity> findAccountByClientId(Long clientId);
}
