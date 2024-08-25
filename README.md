# ChallengeApp
ChallengeApp is a simple Spring Boot application that provides a RESTful API to manage monthly challenges. It allows users to perform CRUD operations (Create, Read, Update, Delete) on challenges.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.3**
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
- **H2 Database** (in-memory)
- **Maven** (for dependency management and build)
- **Jakarta Persistence API (JPA)**
- **Postman** (for API testing)

## Getting Started

### Prerequisites

Make sure you have the following installed on your machine:

- JDK 17 or later
- Maven 3.6+
- Postman (or any REST client for API testing)


The application will start on port 8080.

Access the H2 Database Console:

Open a browser and navigate to http://localhost:8080/h2-console.
Set the JDBC URL to jdbc:h2:mem:test and click "Connect".
Endpoints

1. Get All Challenges
URL: /challenges
Method: GET
Description: Retrieves a list of all challenges.
Response: A JSON array of challenges.

2. Get Challenge by Month
URL: /challenges/{month}
Method: GET
Description: Retrieves a challenge by its month (case-insensitive).
Path Variable:
month: The month to filter challenges.
Response: A JSON object of the challenge or a 404 error if not found.

3. Add a New Challenge

URL: /challenges
Method: POST
Description: Adds a new challenge.
Request Body: JSON object representing the challenge.
json
Copy code
{
  "month": "January",
  "description": "New Year Fitness Challenge"
}
Response: A success message or a failure message.

4. Update an Existing Challenge
URL: /challenges/{id}
Method: PUT
Description: Updates an existing challenge.
Path Variable:
id: The ID of the challenge to update.
Request Body: JSON object with the updated challenge details.
json
Copy code
{
  "month": "January",
  "description": "Updated Fitness Challenge"
}
Response: A success message or a failure message.

5. Delete a Challenge
URL: /challenges/{id}
Method: DELETE
Description: Deletes a challenge by its ID.
Path Variable:
id: The ID of the challenge to delete.
Response: A success message or a failure message.
Testing with Postman
You can use Postman to test the REST API endpoints. Follow these steps:

Open Postman.

Create a new request for each endpoint you want to test:
GET /challenges to retrieve all challenges.
GET /challenges/{month} to retrieve a challenge by month.
POST /challenges to add a new challenge. Make sure to set the request body type to JSON and provide the required fields.
PUT /challenges/{id} to update an existing challenge. Provide the id in the URL and the updated data in the request body.
DELETE /challenges/{id} to delete a challenge by its ID.
Send the request and check the response.

Contributing
Feel free to contribute to this project by opening an issue or submitting a pull request. Contributions are welcome!
