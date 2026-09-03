# CI/CD Fundamentals — Spring Boot App

A minimal Spring Boot app with two endpoints. Used to learn CI/CD basics.

## Endpoints

| Endpoint  | Response                                 |
|-----------|------------------------------------------|
| `/`       | `Hello from Spring Boot CI/CD Pipeline!` |
| `/health` | `OK`                                     |

## How to Run Locally

**Requirements:** Java 17+, Maven

```bash
mvn spring-boot:run
```

Then open your browser or use curl:

```bash
curl http://localhost:8080/
curl http://localhost:8080/health
```

## How to Run with Docker

**Requirements:** Docker

```bash
# Build the image
docker build -t cicd-fundamentals .

# Run the container
docker run -p 8080:8080 cicd-fundamentals
```

Then hit the same endpoints:

```bash
curl http://localhost:8080/
curl http://localhost:8080/health
```

## Docker Image Size

| Version         | Base Image                        | Size     |
|-----------------|-----------------------------------|----------|
| Before (single) | eclipse-temurin:17-jre            | ~270 MB  |
| After (multi)   | eclipse-temurin:17-jre-alpine     | ~180 MB  |

The multi-stage build uses Alpine Linux (a minimal OS) in the final image,
so it only contains what's needed to run the app — not Maven or the full JDK.

## Why smaller images and .dockerignore matter

- **Smaller image** — faster to push/pull from a registry, less storage cost,
  and a smaller attack surface (fewer packages = fewer vulnerabilities).
- **.dockerignore** — stops Docker from copying unnecessary files (like `target/`,
  `.git/`, IDE config) into the build context. This makes builds faster and
  keeps the image clean.

## How to Run Tests

```bash
mvn test
```

## Project Structure

```
src/
  main/java/Ci_Cd_fundamentals/Ci_Cd_fundamentals/
    CiCdFundamentalsApplication.java   # App entry point
    HelloController.java               # The two endpoints
  test/java/Ci_Cd_fundamentals/Ci_Cd_fundamentals/
    HelloControllerTest.java           # Tests for both endpoints
Dockerfile                             # Multi-stage Docker build
.dockerignore                          # Files excluded from Docker build
pom.xml                                # Maven dependencies
README.md                              # This file
```
