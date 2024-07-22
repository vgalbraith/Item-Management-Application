# Item Management Application

Using Spring Boot, created a simple API for creating and managing items (Video Games). The goal will be to build an API that allows storage of these items and track them as needed.

## Requirements
- Build the application using at least Java 17 and Spring Boot 3

- All interactions between a User and the API should happen via HTTP Requests. Using a tool like Postman will allow you to set up these requests.

- All data should be stored in a PostgreSQL database.

- The goal of this project is to review basic application design and structure

- Expectation is to complete 4 of the following User Stories as a **MINIMUM**. The more stories implemented the better:

    - [x] As a user, I can create a new Item
    - [x] As a user, I can view all Items
    - [x] As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - [x] As a user, I can update an Item (Change the name or other properties)
    - [x] As a user, I can delete an Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - [x] As a user, I can create an account to hold my Items
    - [x] As a user, I can login to my account (which is stored in the database)
    - [x] As a user, I can view the Items associated with my account

- Other Optional Requirements include the following:
    - [ ] Giving accounts roles (USER and ADMIN) so Admins can view everyone's Items while a User can only view their own
    - [ ] Using JUnit to test Service Layer methods (70% coverage at least would be optimal)

- **NOTE** Responses from the API must include proper response bodies (in JSON) and **status codes** (i.e. If I try to go to http://localhost:8080/To-Do/5 and there is no resource there, I should receive a 404 status code (NOT FOUND) in the response, but if the resource is there I should receive a 200 status code (OK) instead)
