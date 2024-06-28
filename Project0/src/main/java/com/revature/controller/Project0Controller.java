package com.revature.controller;

import com.revature.entity.VideoGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.entity.Account;
import com.revature.service.AccountService;
import com.revature.service.VideoGameService;

import java.util.List;

@RestController
public class Project0Controller {

    AccountService accountService;
    VideoGameService videoGameService;

    @Autowired
    public Project0Controller(AccountService accountService, VideoGameService videoGameService) {
        this.accountService = accountService;
        this.videoGameService = videoGameService;
    }

    @PostMapping("/games")
    public ResponseEntity<VideoGame> addVideoGame(@RequestBody VideoGame game) {
        VideoGame addedGame = videoGameService.persistVideoGame(game);
        return new ResponseEntity<>(addedGame, HttpStatus.OK);
    }

    @GetMapping("/games")
    public ResponseEntity<List<VideoGame>> viewAllVideoGames() {
        List<VideoGame> games = videoGameService.getAllVideoGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/games/{game_id}")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable int game_id) {
        VideoGame game = videoGameService.getVideoGameById(game_id);
        if (game == null) return null;
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        Account addedAccount = accountService.persistAccount(account);
        return new ResponseEntity<>(addedAccount, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
        Account verifiedAccount = accountService.verifyAccount(account);
        return new ResponseEntity<>(verifiedAccount, HttpStatus.OK);
    }
}