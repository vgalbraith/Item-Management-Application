package com.revature.Project0.controller;

import com.revature.Project0.service.AccountService;
import com.revature.Project0.service.VideoGameService;
import com.revature.Project0.model.VideoGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.Project0.model.Account;

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

    /**
     * Endpoint for creating a new VideoGame.
     * @param game The VideoGame to be created.
     * @return The persisted VideoGame including it's newly assigned game_id.
     */
    @PostMapping("/games")
    public ResponseEntity<VideoGame> addVideoGame(@RequestBody VideoGame game) {
        VideoGame addedGame = videoGameService.persistVideoGame(game);
        return new ResponseEntity<>(addedGame, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all VideoGame objects.
     * @return A list of all VideoGame objects.
     */
    @GetMapping("/games")
    public ResponseEntity<List<VideoGame>> viewAllVideoGames() {
        List<VideoGame> games = videoGameService.getAllVideoGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving a VideoGame given it's game_id.
     * @param game_id
     * @return The associated VideoGame object, empty body if not found.
     */
    @GetMapping("/games/{game_id}")
    public ResponseEntity<VideoGame> getVideoGameById(@PathVariable int game_id) {
        VideoGame game = videoGameService.getVideoGameById(game_id);
        if (game == null) return null;
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    /**
     * Endpoint for updating a VideoGame given it's game_id.
     * @param game_id
     * @param game containing VideoGame data to be updated.
     * @return The number of rows affected.
     */
    @PatchMapping("/games/{game_id}")
    public ResponseEntity<Integer> updateVideoGame(@PathVariable int game_id, @RequestBody VideoGame game) {
        int rows = videoGameService.updateVideoGame(game_id, game);
        return new ResponseEntity<Integer>(rows, HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a VideoGame given it's game_id.
     * @param game_id
     * @return The number of rows affected.
     */
    @DeleteMapping("/games/{game_id}")
    public ResponseEntity<Integer> deleteVideoGame(@PathVariable int game_id) {
        int rows = videoGameService.deleteVideoGame(game_id);
        return new ResponseEntity<Integer>(rows, HttpStatus.OK);
    }

    /**
     * Endpoint for registering a new Account.
     * @param account The Account to be registered.
     * @return The persisted Account including it's newly assigned account_id.
     */
    @PostMapping("/account/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        Account addedAccount = accountService.persistAccount(account);
        return new ResponseEntity<>(addedAccount, HttpStatus.OK);
    }

    /**
     * Endpoint for verifying a user login.
     * @param account An account containing a username/password combination to be verified.
     * @return The verified account object.
     */
    @PostMapping("/account/login")
    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
        Account verifiedAccount = accountService.verifyAccount(account);
        return new ResponseEntity<>(verifiedAccount, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all VideoGame objects owned by the given Account.
     * @param account
     * @return A list of all applicable VideoGame objects.
     */
    @GetMapping("/account/games")
    public ResponseEntity<List<VideoGame>> ViewAccountInventory(@RequestBody Account account) {
        Account verifiedAccount = accountService.verifyAccount(account);
        List<VideoGame> inventory = videoGameService.viewAccountInventory(verifiedAccount.getAccount_id());
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}