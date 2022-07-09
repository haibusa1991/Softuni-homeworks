package com;

import com.models.Account;
import com.models.User;
import com.servces.AccountService;
import com.servces.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class L01ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    public L01ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User("Ivan", 25);
        Account account = new Account(new BigDecimal("200"), user);

        user.addAccount(account);

        userService.registerUser(user);

        accountService.depositMoney(new BigDecimal("5"),account.getId());
//        accountService.withdrawMoney(new BigDecimal("50000"),account.getId());

    }
}
