# Revature Software Engineer Training

This repository contains all the projects and exercises for my Software Engineer training program at Revature. Each project is organized in its own directory with detailed documentation and source code.

## Table of Contents

1. [Project 0: Item Management Application](#project-0-item-management-application)

## Projects

### Project 0: Item Management Application

**Description:**  
Project 0 is focused on creating a simple API for managing items. The items can be anything, such as Collectibles, Animals, Employees, Video Games, Shoes, Clothing, etc. The goal is to build an API that allows you to store and track these items.

**Contents:**
- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [License](#license)

#### Introduction

Project 0 involves building an API using Spring Boot (optional) to create and manage items. This project helps in understanding the basics of API development, data storage, and management using modern frameworks.

#### Installation

To install and set up Project 0 on your local machine:

1. Clone the repository:
    ```sh
    git clone https://github.com/2406-Ryan-Java-FS/Victor_Galbraith.git
    ```
2. Navigate to the Project 0 directory:
    ```sh
    cd Victor_Galbraith/Project0
    ```
3. If using Spring Boot, ensure you have Java and Maven installed on your machine.
4. Install dependencies and build the project:
    ```sh
    mvn clean install
    ```

#### Usage

Instructions on how to run and use the project:

1. Start the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```
2. The API will be available at `http://localhost:8080`.
3. Use a tool like Postman or curl to interact with the API.

API Endpoints:
- `POST /games`: As a user, I can create a new VideoGame object
- `GET /games`: As a user, I can view all VideoGame objects
- `GET /games/{game_id}`: As a user, I can view a singular VideoGame object by its game_id
- `PATCH /games/{game_id}`: As a user, I can update an VideoGame object
- `DELETE /games/{game_id}`: As a user, I can delete an VideoGame object by its game_id
- `POST /register`: As a user, I can create an Account to hold my VideoGame objects
- `POST /login`: As a user, I can login to my Account
- `POST /account`: As a user, I can view the VideoGame objects associated with my Account

#### Features

- Create, read, update, and delete items.
- Basic error handling and validation.

---

This README will be updated with additional projects and exercises as I progress through my training at Revature.
