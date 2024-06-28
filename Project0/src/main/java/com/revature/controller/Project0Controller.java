package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Account;
import com.revature.service.AccountService;
import com.revature.service.VideoGameService;

@RestController
public class Project0Controller {

    private final AccountService accountService;
    private final VideoGameService videoGameService;

    @Autowired
    public Project0Controller(AccountService accountService, VideoGameService videoGameService) {
        this.accountService = accountService;
        this.videoGameService = videoGameService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        Account addedAccount = accountService.persistAccount(account);
        return new ResponseEntity<Account>(addedAccount, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
        Account verifiedAccount = accountService.verifyAccount(account);
        return new ResponseEntity<Account>(verifiedAccount, HttpStatus.OK);
    }
}