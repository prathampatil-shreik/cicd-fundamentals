# CI/CD Fundamentals — Spring Boot App

A minimal Spring Boot app used to learn CI/CD basics end to end:
local run → Docker → GitHub Actions → ECR → ECS Fargate.

## Endpoints

| Endpoint  | Response                                 |
|-----------|------------------------------------------|
| `/`       | `Hello from Spring Boot CI/CD Pipeline!` |
| `/health` | `OK`                                     |

## Project Structure

```
cicd-fundamentals/
├── app/                        # Spring Boot source code
│   ├── src/
│   └── pom.xml
├── deploy/
│   └── ecs-task-definition.json   # ECS Fargate task definition
├── docs/
│   ├── deployment-summary.md      # AWS service, URL, deploy steps, rollback
│   ├── research.md                # Key concepts explained
│   ├── runbook.md                 # How to run, deploy, rollback
│   └── screenshots/               # Pipeline and AWS screenshots
├── .github/workflows/
│   └── ci.yml                     # GitHub Actions CI/CD pipeline
├── Dockerfile                     # Multi-stage Docker build
├── .dockerignore
└── README.md
```

## Run Locally

```bash
cd app
mvn spring-boot:run
```

## Run with Docker

```bash
docker build -t cicd-fundamentals .
docker run -p 8080:8080 cicd-fundamentals
```

## CI/CD Pipeline

Every push to `main` automatically:
1. Runs tests
2. Builds the JAR
3. Builds the Docker image
4. Pushes to Amazon ECR with `latest` and commit SHA tags

## Deployment

App runs on **ECS Fargate** pulling the image from ECR.
See `docs/deployment-summary.md` for full details and rollback steps.
