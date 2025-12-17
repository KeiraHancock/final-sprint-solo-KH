# Final Sprint – Binary Search Tree Application
## Author: Keira Hancock

This project is a Spring Boot application developed for the Data Structures and Algorithms Final Sprint.

## Features
- Users can enter a list of numbers to generate a Binary Search Tree (BST)
- The BST is built using sequential insertion
- The resulting tree is returned as a JSON structure
- Input values and tree results are stored in an H2 database
- Previous tree results can be viewed
- Includes unit tests for BST functionality

## Routes
- `/enter-numbers` – Input page for entering numbers and viewing the tree result
- `/process-numbers` – Processes input and returns the BST as JSON
- `/previous-trees` – Displays previously saved tree results
- `/h2-console` – H2 database console (optional)

## Technologies Used
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5

## Running the Application
```
./mvnw spring-boot:run
```
The application will be available at:
```
http://localhost:8080/enter-numbers
```

## Running Tests
```
./mvnw test
```

---
