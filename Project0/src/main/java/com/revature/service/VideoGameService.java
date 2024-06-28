package com.revature.service;

import com.revature.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.VideoGame;
import com.revature.repository.VideoGameRepository;

import java.util.List;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;

    @Autowired
    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    public VideoGame persistVideoGame(VideoGame game) {

        if (game.getTitle().equals("")) {
            throw new BadRequestException("Game title cannot be blank.");
        }

        return videoGameRepository.save(game);
    }

    public List<VideoGame> getAllVideoGames() {
        return videoGameRepository.findAll();
    }
}