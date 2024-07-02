package com.revature;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.VideoGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RetrieveAllVideoGamesTest {
    ApplicationContext app;
    HttpClient webClient;
    ObjectMapper objectMapper;

    /**
     * Before every test: restart the app, and create a new webClient and ObjectMapper
     *
     * @throws InterruptedException
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        webClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        String[] args = new String[]{};
        app = SpringApplication.run(Project0Application.class, args);
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        SpringApplication.exit(app);
    }

    @Test
    public void getAllVideoGamesVideoGamesAvailable() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games"))
                .build();
        HttpResponse<String> response = webClient.send(request, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        List<VideoGame> expectedResult = new ArrayList<>();
        expectedResult.add(new VideoGame(1, "Title1", "platform1", 1));
        expectedResult.add(new VideoGame(2, "Title2", "platform2", 2));
        expectedResult.add(new VideoGame(3, "Title3", "platform3", 3));
        expectedResult.add(new VideoGame(4, "Title4", "platform4", 1));
        List<VideoGame> actualResult = objectMapper.readValue(response.body(), new TypeReference<>() {
        });
        Assertions.assertEquals(expectedResult, actualResult, "Expected=" + expectedResult + ", Actual=" + actualResult);
    }
}