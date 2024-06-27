package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.VideoGame;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {
    VideoGame findVideoGameByTitle(String title);
}