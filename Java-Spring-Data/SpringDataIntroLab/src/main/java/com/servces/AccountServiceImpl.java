package com.servces;

import com.models.Account;
import com.models.User;
import com.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepository.findAccountById(accountId);

        checkIfAccountExists(accountId);
        checkIfUserExists(accountId);

        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalStateException("Account does not have enough money available!");
        }

        account.setBalance(account.getBalance().subtract(amount));
    }

    @Override
    public void depositMoney(BigDecimal amount, Long accountId) {
//        checkIfAccountExists(id);
        checkIfUserExists(accountId);

        if (amount.signum() < 0) {
            throw new IllegalStateException("Deposit amount cannot be negative!");
        }

        Account account = accountRepository.findAccountById(accountId);
        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void registerUserAccounts(User user) {
        Set<Account> currentAccounts = user.getAccounts();

    }

    private void checkIfAccountExists(Long accountId) {
        if (accountRepository.findAccountById(accountId) == null) {
            throw new IllegalStateException("Account with such id does not exist!");
        }
    }

    private void checkIfUserExists(Long accountId) {
        if (accountRepository.findAccountById(accountId).getUser() == null) {
            throw new IllegalStateException("Account has no user associated!");
        }
    }
}
