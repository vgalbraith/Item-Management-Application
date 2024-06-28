package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entity.VideoGame;
import com.revature.repository.VideoGameRepository;

@Service
public class VideoGameService {

    @Autowired
    VideoGameRepository videoGameRepository;

    @Autowired
    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }
}