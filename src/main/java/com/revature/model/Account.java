package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer account_id,
        String username,
        String password
) {
}
