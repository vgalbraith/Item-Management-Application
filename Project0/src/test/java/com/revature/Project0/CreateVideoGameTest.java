package com.revature.Project0;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.revature.Project0Application;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.revature.entity.VideoGame;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateVideoGameTest {
    ApplicationContext app;
    HttpClient webClient;
    ObjectMapper objectMapper;

    /**
     * TODO: reset the database
     * Before every test, reset the database, restart the app, and create a new webClient and ObjectMapper
     * @throws InterruptedException
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        webClient = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
        String[] args = new String[] {};
        app = SpringApplication.run(Project0Application.class, args);
        Thread.sleep(500);
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(500);
        SpringApplication.exit(app);
    }


    /**
     * Sending an http request to POST localhost:8080/games with valid credentials
     *
     * Expected Response:
     *  Status Code: 200
     *  Response Body: JSON representation of message object
     */
    @Test
    public void createVideoGameSuccessful() throws IOException, InterruptedException {
        String json = "{\"game_id\":9999,\"title\": \"Test Title 1\",\"platform\": \"PC\",\"owned_by\": 1}";
        HttpRequest postMessageRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postMessageRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(200, status, "Expected Status Code 200 - Actual Code was: " + status);
        ObjectMapper om = new ObjectMapper();
        VideoGame expectedResult = new VideoGame(5, "Test Title 1", "PC", 1);
        VideoGame actualResult = om.readValue(response.body(), VideoGame.class);
        Assertions.assertEquals(expectedResult, actualResult, "Expected="+expectedResult + ", Actual="+actualResult);
    }

    /**
     * Sending an http request to POST localhost:8080/games with empty title
     *
     * Expected Response:
     *  Status Code: 400
     */
    @Test
    public void createVideoGameTitleTextBlank() throws IOException, InterruptedException {
        String json = "{\"game_id\":9999,\"title\": \"\",\"platform\": \"PC\",\"owned_by\": 1}";
        HttpRequest postMessageRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postMessageRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(400, status, "Expected Status Code 400 - Actual Code was: " + status);
    }


    /**
     * Sending an http request to POST localhost:8080/games with title length greater than 99
     *
     * Expected Response:
     *  Status Code: 400
     *  Response Body:
     */
    @Test
    public void createVideoGameTitleGreaterThan99() throws IOException, InterruptedException {
        String json = "{\"game_id\":9999,"
                + "\"title\": \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\""
                + "\"platform\": \"PC\",\"owned_by\": 1}";
        HttpRequest postMessageRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postMessageRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(400, status, "Expected Status Code 400 - Actual Code was: " + status);
    }

    /**
     * Sending an http request to POST localhost:8080/games with a user id that doesnt exist in db
     *
     * Expected Response:
     *  Status Code: 400
     */
    @Test
    public void createVideoGameUserNotInDb() throws IOException, InterruptedException {
        String json = "{\"game_id\":9999,\"title\": \"Test Title 1\",\"platform\": \"PC\",\"owned_by\": 9595959}";
        HttpRequest postMessageRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/games"))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = webClient.send(postMessageRequest, HttpResponse.BodyHandlers.ofString());
        int status = response.statusCode();
        Assertions.assertEquals(400, status, "Expected Status Code 400 - Actual Code was: " + status);
    }
}