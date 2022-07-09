package com.servces;

import com.models.Account;
import com.models.User;

import java.math.BigDecimal;
import java.util.Set;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id);

    void depositMoney(BigDecimal amount, Long id);

    void registerUserAccounts(User user);

}
