package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.revature")
@EntityScan("com.revature.entity")
@EnableJpaRepositories("com.revature.repository")
public class Project0Application {

    public static void main(String[] args) {
        SpringApplication.run(Project0Application.class, args);
    }

}