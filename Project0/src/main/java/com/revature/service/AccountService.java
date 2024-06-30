package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.Account;
import com.revature.exception.ConflictException;
import com.revature.exception.UnauthorizedException;
import com.revature.exception.BadRequestException;
import com.revature.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Used to persist an Account to the repository.
     * @param account The Account to be added.
     * @return The persisted Account including it's newly assigned account_id.
     * @throws BadRequestException if there's an issue with the client's request.
     * @throws ConflictException if the username is already associated with a registered Account.
     */
    public Account persistAccount(Account account) {
        if (account.getUsername().isEmpty()) {
            throw new BadRequestException("Username cannot be blank.");
        }

        if (account.getPassword().length() < 4) {
            throw new BadRequestException("Password must be at least 4 characters long.");
        }

        if (accountRepository.findAccountByUsername(account.getUsername()) != null) {
            throw new ConflictException("Username already exists.");
        }

        return accountRepository.save(account);
    }

    public Account verifyAccount(Account account) {
        Account verifiedAccount = accountRepository.findAccountByUsername(account.getUsername());
        if (verifiedAccount == null) {
            throw new UnauthorizedException("Invalid username.");
        }

        if (!verifiedAccount.getPassword().equals(account.getPassword())) {
            throw new UnauthorizedException("Invalid password.");
        }

        return verifiedAccount;
    }
}