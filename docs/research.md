# Research Notes

## What is CI/CD?
- **CI (Continuous Integration)** — automatically build and test code on every push
- **CD (Continuous Deployment)** — automatically deploy the tested code to production

## Tools Used
| Tool | Purpose |
|---|---|
| GitHub Actions | Runs the CI/CD pipeline automatically on push |
| Docker | Packages the app into a portable container |
| Amazon ECR | Stores Docker images in AWS |
| Amazon ECS Fargate | Runs the container on AWS without managing servers |

## Why Multi-Stage Docker Build?
- Stage 1 uses a full Maven + JDK image to compile and build the JAR
- Stage 2 uses a tiny Alpine JRE image just to run the JAR
- Result: final image is ~180MB instead of ~500MB
- Smaller = faster to push/pull, less storage cost, fewer vulnerabilities

## Why .dockerignore?
Stops Docker from copying unnecessary files into the build context:
- `target/` — already compiled locally, not needed
- `.git/` — version history, not needed in image
- `README.md`, IDE files — not needed to run the app
- Makes builds faster and images cleaner

## Why store AWS keys as GitHub Secrets?
- Keys committed to code = anyone can see them = security breach
- GitHub Secrets are encrypted and only exposed to the pipeline at runtime
- They never appear in logs (GitHub masks them automatically)

## Why tag images with commit SHA?
- `latest` always points to the newest image
- Commit SHA (e.g. `91ae457`) ties the image to the exact code that built it
- Makes rollback easy — you know exactly which image = which code
