package com.revature.Project0.service;

import com.revature.Project0.exception.BadRequestException;
import com.revature.Project0.repository.VideoGameRepository;
import com.revature.Project0.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Project0.model.VideoGame;

import java.util.List;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;
    AccountRepository accountRepository;

    @Autowired
    public VideoGameService(VideoGameRepository videoGameRepository, AccountRepository accountRepository) {
        this.videoGameRepository = videoGameRepository;
        this.accountRepository = accountRepository;
    }

    /**
     * Used to persist a VideoGame to the repository.
     * @param game The VideoGame to be added.
     * @return The persisted VideoGame including it's newly assigned game_id.
     * @throws BadRequestException if there's an issue with the client's request.
     */
    public VideoGame persistVideoGame(VideoGame game) {

        if (game.getTitle().isEmpty()) {
            throw new BadRequestException("Game title cannot be blank.");
        }

        if (game.getOwned_by() != null && !accountRepository.existsById(game.getOwned_by())) {
            throw new BadRequestException("Owner does not exist.");
        }

        return videoGameRepository.save(game);
    }

    /**
     * Used to retrieve all VideoGame objects from the repository.
     * @return A list of all VideoGame objects.
     */
    public List<VideoGame> getAllVideoGames() {
        return videoGameRepository.findAll();
    }

    /**
     * Used to retrieve a VideoGame from the repository given it's game_id.
     * @param game_id
     * @return The associated VideoGame object, null if game_id not found.
     */
    public VideoGame getVideoGameById(int game_id) {
        return videoGameRepository.findById(game_id).orElse(null);
    }

    /**
     * Used to update a VideoGame in the repository given it's game_id.
     * @param game_id
     * @param game VideoGame object containing updated variables.
     * @return The number of rows affected.
     * @throws BadRequestException if there's an issue with the client's request.
     */
    public int updateVideoGame(int game_id, VideoGame game) {

        if (!videoGameRepository.existsById(game_id)) {
            throw new BadRequestException("game_id is invalid.");
        }

        if (game.getOwned_by() != null && !accountRepository.existsById(game.getOwned_by())) {
            throw new BadRequestException("account_id is invalid.");
        }

        if (game.getTitle().isEmpty()) {
            throw new BadRequestException("Game title cannot be blank.");
        }

        if (game.getTitle().length() >= 100) {
            throw new BadRequestException("Game title must be less than 100 characters long.");
        }

        VideoGame updatedVideoGame = this.getVideoGameById(game_id);
        updatedVideoGame.setTitle(game.getTitle());
        updatedVideoGame.setPlatform(game.getPlatform());
        updatedVideoGame.setOwned_by(game.getOwned_by());
        videoGameRepository.save(updatedVideoGame);
        return 1;
    }

    /**
     * Used to delete a VideoGame from the repository given it's game_id.
     * @param game_id
     * @return The number of rows affected.
     */
    public int deleteVideoGame(int game_id) {
        if (videoGameRepository.existsById(game_id)) {
            videoGameRepository.deleteById(game_id);
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Endpoint for retrieving all VideoGame objects owned by the given account_id.
     * @param account_id
     * @return A list of all applicable VideoGame objects.
     */
    public List<VideoGame> viewAccountInventory(int account_id) {
        return videoGameRepository.findAllByAccountId(account_id);
    }
}