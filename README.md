## Getting Started

To run the backend of the application, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Treev13/Chess-Statistics
   cd chess-statistics

2. **Configure Database:**

   Set up your database connection details in the application.properties file.

3. **Build and Run:**

   Build and run the Spring Boot application using Maven in the backend folder (chess-backend-with-JPA):
   mvn spring-boot:run
   The backend should now be running at http://localhost:8080.

## API Endpoints

- GET /api/players/all: Get all questions along with their answer counts.
- GET /api/players/player/{id}: Get details of a specific question by ID.
- POST /questions/: Add a new question.
- DELETE /questions/{id}: Delete a question by ID.
- GET /answers/{id}: Get all answers for a specific question by ID.
- POST /answers/: Add a new answer to a question.
- DELETE /answers/{id}: Delete an answer by ID.

## Technologies Used

- Java
- Spring Boot
- Spring Data JDBC
- PostreSQL (or your preferred database)

## Contributing
Contributions are welcome! Feel free to open issues and pull requests.
