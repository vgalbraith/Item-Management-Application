package com.revature.repository;

import com.revature.model.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Integer> {

    /**
     * Query to retrieve all VideoGame objects owned by a particular Account, given their account_id.
     *
     * @param account_id Equivalent to owned_by.
     * @return A list of all applicable VideoGame objects.
     */
    @Query(value = "SELECT * FROM video_games WHERE owned_by = :account_id", nativeQuery = true)
    List<VideoGame> findAllByAccountId(@Param("account_id") int account_id);

}