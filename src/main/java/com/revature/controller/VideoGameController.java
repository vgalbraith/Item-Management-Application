package com.revature.controller;

import com.revature.model.Account;
import com.revature.model.VideoGame;
import com.revature.repository.AccountRepository;
import com.revature.repository.VideoGameRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class VideoGameController {

    private final AccountRepository accountRepository;
    private final VideoGameRepository videoGameRepository;

    public VideoGameController(AccountRepository accountRepository, VideoGameRepository videoGameRepository) {
        this.accountRepository = accountRepository;
        this.videoGameRepository = videoGameRepository;
    }

    /**
     * Endpoint for retrieving a VideoGame given its game_id.
     *
     * @param game_id The ID of the VideoGame to retrieve.
     * @return ResponseEntity containing the associated VideoGame object if found,
     *         or a 404 Not Found status with an empty body if the game is not found.
     * <p>
     * Possible HTTP status codes:
     * - 200 OK: If the VideoGame is found.
     * - 404 Not Found: If no VideoGame exists with the provided game_id.
     */
    @GetMapping("/{game_id}")
    public ResponseEntity<VideoGame> findById(@PathVariable int game_id) {
        Optional<VideoGame> videoGameOptional = videoGameRepository.findById(game_id);
        return videoGameOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    /**
//     * Endpoint for creating a new VideoGame.
//     *
//     * @param game The VideoGame to be created.
//     * @return The persisted VideoGame including it's newly assigned game_id.
//     */
//    @PostMapping("/games")
//    public ResponseEntity<VideoGame> addVideoGame(@RequestBody VideoGame game) {
//        VideoGame addedGame = videoGameService.persistVideoGame(game);
//        return new ResponseEntity<>(addedGame, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for retrieving all VideoGame objects.
//     *
//     * @return A list of all VideoGame objects.
//     */
//    @GetMapping("/games")
//    public ResponseEntity<List<VideoGame>> viewAllVideoGames() {
//        List<VideoGame> games = videoGameService.getAllVideoGames();
//        return new ResponseEntity<>(games, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for updating a VideoGame given it's game_id.
//     *
//     * @param game_id
//     * @param game containing VideoGame data to be updated.
//     * @return The number of rows affected.
//     */
//    @PatchMapping("/games/{game_id}")
//    public ResponseEntity<Integer> updateVideoGame(@PathVariable int game_id, @RequestBody VideoGame game) {
//        int rows = videoGameService.updateVideoGame(game_id, game);
//        return new ResponseEntity<Integer>(rows, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for deleting a VideoGame given it's game_id.
//     *
//     * @param game_id
//     * @return The number of rows affected.
//     */
//    @DeleteMapping("/games/{game_id}")
//    public ResponseEntity<Integer> deleteVideoGame(@PathVariable int game_id) {
//        int rows = videoGameService.deleteVideoGame(game_id);
//        return new ResponseEntity<Integer>(rows, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for registering a new Account.
//     *
//     * @param account The Account to be registered.
//     * @return The persisted Account including it's newly assigned account_id.
//     */
//    @PostMapping("/account/register")
//    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
//        Account addedAccount = accountService.persistAccount(account);
//        return new ResponseEntity<>(addedAccount, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for verifying a user login.
//     *
//     * @param account An account containing a username/password combination to be verified.
//     * @return The verified account object.
//     */
//    @PostMapping("/account/login")
//    public ResponseEntity<Account> loginAccount(@RequestBody Account account) {
//        Account verifiedAccount = accountService.verifyAccount(account);
//        return new ResponseEntity<>(verifiedAccount, HttpStatus.OK);
//    }
//
//    /**
//     * Endpoint for retrieving all VideoGame objects owned by the given account_id.
//     *
//     * @param account_id
//     * @return A list of all applicable VideoGame objects.
//     */
//    @GetMapping("/account/{account_id}")
//    public ResponseEntity<List<VideoGame>> ViewAccountInventory(@PathVariable int account_id) {
//        List<VideoGame> inventory = videoGameService.viewAccountInventory(account_id);
//        return new ResponseEntity<>(inventory, HttpStatus.OK);
//    }
}