# Deployment Summary

## AWS Service Used
**Amazon ECS Fargate** — chosen because:
- No servers to manage (serverless containers)
- Scales automatically
- Pay only for what you use
- Pulls image directly from ECR

## Application URL
- Home: `http://<ecs-public-ip>:8080/`
- Health: `http://<ecs-public-ip>:8080/health`

## Deploy Steps
1. Push code to `main` branch
2. GitHub Actions pipeline runs automatically:
   - Runs tests
   - Builds JAR
   - Builds Docker image
   - Pushes to ECR with `latest` and commit SHA tags
3. ECS pulls the `latest` image and runs it as a Fargate task

## How to Redeploy (new image)
1. Make code change → push to `main`
2. Pipeline builds and pushes new image to ECR
3. In ECS console → Service → **"Force new deployment"**
4. ECS pulls the new `latest` image automatically

## How to Roll Back
If the new image is broken:
1. Go to ECR → find the previous image by its commit SHA tag
2. In ECS Task Definition → **"Create new revision"**
3. Change the image tag from `latest` to the previous commit SHA
4. Update the ECS service to use the previous task definition revision
5. ECS will stop the broken container and start the old one
