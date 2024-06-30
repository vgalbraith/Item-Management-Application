package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entity.VideoGame;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {
}