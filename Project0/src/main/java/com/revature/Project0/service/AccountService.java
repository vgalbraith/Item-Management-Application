package com.revature.Project0.service;

import com.revature.Project0.exception.BadRequestException;
import com.revature.Project0.exception.ConflictException;
import com.revature.Project0.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project0.model.Account;
import com.revature.Project0.repository.AccountRepository;

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

    /**
     * Used to verify a login.
     * @param account Account object containing the username and password to verify.
     * @return The verified Account object.
     * @throws UnauthorizedException if the username and/or password are invalid.
     */
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