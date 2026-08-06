# AWS ECS Deployment Checklist

## 1. Prerequisites

- AWS account with permissions for ECR, ECS, IAM, VPC, ALB, and CloudWatch
- Docker installed locally
- Terraform installed
- AWS CLI configured

## 2. Build and push images

```bash
aws ecr create-repository --repository-name zenbank-app --region us-east-1
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <account-id>.dkr.ecr.us-east-1.amazonaws.com
```

## 3. Build and tag images

```bash
docker build -t zenbank-auth ./auth-service
docker tag zenbank-auth:latest <account-id>.dkr.ecr.us-east-1.amazonaws.com/zenbank-app:auth-latest
docker push <account-id>.dkr.ecr.us-east-1.amazonaws.com/zenbank-app:auth-latest
```

## 4. Create ECS cluster and service

- Run Terraform from the terraform folder
- Apply the ECS task definition and service resources

## 5. Configure networking

- Create or reuse a VPC
- Attach public subnets
- Configure security groups for ALB and ECS tasks

## 6. Add monitoring

- Enable CloudWatch logs
- Add health checks via ALB target groups
- Configure alerts for CPU and memory

## 7. Optional improvements

- Add Route 53 DNS record
- Add ACM certificate for HTTPS
- Add auto-scaling policies
- Add secrets manager for JWT keys
