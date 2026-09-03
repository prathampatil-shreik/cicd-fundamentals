# CI/CD Fundamentals — Spring Boot App

A minimal Spring Boot app with two endpoints. Used to learn CI/CD basics.

## Endpoints

| Endpoint  | Response                              |
|-----------|---------------------------------------|
| `/`       | `Hello from Spring Boot CI/CD Pipeline!` |
| `/health` | `OK`                                  |

## How to Run Locally

**Requirements:** Java 17+, Maven

```bash
./mvnw spring-boot:run
```

Then open your browser or use curl:

```bash
curl http://localhost:8080/
curl http://localhost:8080/health
```

## How to Run Tests

```bash
./mvnw test
```

## Project Structure

```
src/
  main/java/Ci_Cd_fundamentals/
    CiCdFundamentalsApplication.java   # App entry point
    HelloController.java               # The two endpoints
  test/java/Ci_Cd_fundamentals/
    HelloControllerTest.java           # Tests for both endpoints
pom.xml                                # Dependencies
```
