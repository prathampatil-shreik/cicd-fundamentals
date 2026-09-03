# Runbook

## Run Locally
```bash
cd app
mvn spring-boot:run
```
Endpoints: `http://localhost:8080/` and `http://localhost:8080/health`

## Run with Docker Locally
```bash
docker build -t cicd-fundamentals .
docker run -p 8080:8080 cicd-fundamentals
```

## Run Tests
```bash
cd app
mvn test
```

## Trigger CI/CD Pipeline
```bash
git add .
git commit -m "your message"
git push origin main
```
Pipeline runs automatically on GitHub Actions.

## Force Redeploy on ECS
1. Go to ECS Console → Clusters → `cicd-cluster`
2. Click `cicd-service` → **"Update service"**
3. Check **"Force new deployment"** → Click **"Update"**

## Roll Back to Previous Image
1. Go to ECR → `cicd-fundamentals` repo → find previous image SHA tag
2. Go to ECS → Task Definitions → `cicd-task`
3. Create new revision → change image tag to previous SHA
4. Go to Service → Update → select the previous task definition revision
