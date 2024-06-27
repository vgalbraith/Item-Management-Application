package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.Account;
import com.revature.entity.VideoGame;
import com.revature.service.AccountService;
import com.revature.service.VideoGameService;

@RestController
public class Project0Controller {

    private final accountService;
    private final videoGameService;

    @Autowired
    public SocialMediaController(AccountService accountService, VideoGameService videoGameService) {
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