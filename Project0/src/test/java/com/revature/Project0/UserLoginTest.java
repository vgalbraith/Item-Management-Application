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

import com.revature.entity.Account;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserLoginTest {
	ApplicationContext app;
	HttpClient webClient;
	ObjectMapper objectMapper;

	/**
	 * Before every test: restart the app, and create a new webClient and ObjectMapper
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
	 * Sending an http request to POST localhost:8080/account/login with valid username and password
	 *
	 * Expected Response:
	 *  Status Code: 200
	 *  Response Body: JSON representation of user object
	 */
	@Test
	public void loginSuccessful() throws IOException, InterruptedException {
		String json = "{\"account_id\":0,\"username\":\"user1\",\"password\":\"pass1\"}";
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/account/login"))
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.header("Content-Type", "application/json")
				.build();
		HttpResponse<String> response = webClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		int status = response.statusCode();
		Assertions.assertEquals(200, status);
		ObjectMapper om = new ObjectMapper();
		Account expectedResult = new Account(1, "user1", "pass1");
		Account actualResult = om.readValue(response.body(), Account.class);
		Assertions.assertEquals(expectedResult, actualResult);
	}

	/**
	 * Sending an http request to POST localhost:8080/account/login with invalid username
	 *
	 * Expected Response:
	 * 	Status Code: 401
	 */
	@Test
	public void loginInvalidUsername() throws IOException, InterruptedException {
		String json = "{\"account_id\":9999,\"username\":\"testuser404\",\"password\":\"password\"}";
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/account/login"))
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.header("Content-Type", "application/json")
				.build();
		HttpResponse<String> response = webClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		int status = response.statusCode();
		Assertions.assertEquals(401, status, "Expected Status Code 401 - Actual Code was: " + status);
	}


	/**
	 * Sending an http request to POST localhost:8080/account/login with invalid password
	 *
	 * Expected Response:
	 * 	Status Code: 401
	 */
	@Test
	public void loginInvalidPassword() throws IOException, InterruptedException {
		String json = "{\"account_id\":9999,\"username\":\"user1\",\"password\":\"pass404\"}";
		HttpRequest postRequest = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/account/login"))
				.POST(HttpRequest.BodyPublishers.ofString(json))
				.header("Content-Type", "application/json")
				.build();
		HttpResponse<String> response = webClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
		int status = response.statusCode();
		Assertions.assertEquals(401, status, "Expected Status Code 401 - Actual Code was: " + status);
	}
}