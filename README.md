<h1 align="center">Assembly Language Application</h1>

<p align="center">
    <a href="https://www.java.com/" target="_blank">
        <img src="https://img.shields.io/badge/Java-17-red" alt="Java 17">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
        <img src="https://img.shields.io/badge/Maven-4.0.0-blue" alt="Maven 4.0.0">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/Spring Boot-3.2.4-brightgreen" alt="Spring Boot 3.2.4">
    </a>
</p>

<hr>
This is a Spring Boot application that connects to a MySQL database and runs in Docker containers using Docker Compose.
<hr>


## Prerequisites

- Docker
- Docker Compose
- Java 17 or later
- Maven

## Getting Started

### Clone the Repository

```bash

cd assembly-language-app
```

## Build the Application
   - Before running the application, you need to build it using Maven.
     ```
     mvn clean install -DskipTests
     ```

## Building and Running the Containers
  - Use Docker Compose to build and run the containers:
  ```
  docker compose up  
  ```
![Screenshot (475)]()
![Screenshot (474)]()
