package com.revature.repository;

import com.revature.model.VideoGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends CrudRepository<VideoGame, Integer> {
}