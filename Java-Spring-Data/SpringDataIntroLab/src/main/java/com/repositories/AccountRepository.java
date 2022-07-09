package com.repositories;

import com.models.Account;
import com.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountById(Long accountId);

    Set<Account> findAllByUserId(Long userId);
}
