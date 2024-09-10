package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record VideoGame(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer game_id,
        String title,
        String platform,
        Integer owned_by
) {
}
