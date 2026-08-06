# AWS Deployment Guide for the Microservices Project

This guide explains how to deploy the Spring Boot microservices on AWS in a simple and interview-friendly way using ECS, Load Balancer, DNS, CloudWatch, networking, task definitions, scaling, Docker, and more.

## 1. What you will deploy

Deploy these services on AWS:

- API Gateway
- Auth Service
- Order Service
- Inventory Service
- Payment Service
- Eureka Server
- Kafka or managed messaging service

## 2. Recommended AWS services

- ECS Fargate: run containers without managing servers
- Application Load Balancer (ALB): expose services and distribute traffic
- Route 53: assign a domain or subdomain
- CloudWatch: monitor logs and metrics
- IAM: secure access between services
- VPC: private networking for services
- Security Groups: control inbound and outbound traffic
- ECR: store Docker images
- ACM: SSL/TLS certificates

## 3. Simple architecture

```text
Internet -> Route 53 -> ALB -> ECS Services -> Containers
                           |-> Auth Service
                           |-> Order Service
                           |-> Inventory Service
                           |-> Payment Service
                           |-> Gateway
```

## 4. Step-by-step flow

### Step 1: Create a VPC

- Create a VPC with public and private subnets
- Public subnets: ALB and NAT Gateway
- Private subnets: ECS tasks

### Step 2: Create an ECR repository

- Create one repository per service or one shared repository
- Push Docker images to ECR

### Step 3: Create ECS Cluster

- Create an ECS cluster with Fargate
- Choose VPC and subnets

### Step 4: Create Task Definitions

Each service needs a task definition with:

- CPU and memory
- Container image from ECR
- Port mappings
- Environment variables
- IAM role
- Logging configuration

Example task definition values:

- Auth Service: port 9090
- Order Service: port 8081
- Inventory Service: port 8082
- Payment Service: port 8083
- Gateway: port 9091

### Step 5: Create ECS Services

- Create one ECS service per microservice
- Attach the service to the ALB
- Set desired count = 1 initially

### Step 6: Create an Application Load Balancer

- Create ALB in public subnets
- Add target groups for each service
- Configure listener on port 80 and 443

### Step 7: Configure DNS with Route 53

- Create a hosted zone
- Point your domain/subdomain to the ALB
- Example: api.example.com

### Step 8: Enable CloudWatch logs

- Add logging driver in task definition
- View logs in CloudWatch
- Monitor CPU, memory, and request count

## 5. Networking basics

- Public subnet: ALB can receive internet traffic
- Private subnet: containers run safely inside the VPC
- Security groups:
  - ALB allows HTTP/HTTPS from the internet
  - ECS services allow traffic only from ALB
- Port mapping example:
  - Auth: 9090
  - Order: 8081
  - Inventory: 8082
  - Payment: 8083
  - Gateway: 9091

## 6. Scaling concepts

### Vertical scaling

- Increase CPU and memory of a task
- Good for small upgrades

### Horizontal scaling

- Increase number of tasks behind the load balancer
- Good for traffic growth

Example:

- Start with 1 task per service
- Scale to 2 or 3 tasks when traffic increases

## 7. CDN concept

- CloudFront can be used in front of your public API endpoint
- Good for caching static assets and improving performance
- For APIs, use it only if needed

## 8. Docker and container image flow

1. Create Dockerfile for each service
2. Build image locally
3. Tag image
4. Push image to ECR
5. Reference image from ECS task definition

## 9. Kubernetes note

Kubernetes is an alternative to ECS.

- ECS is AWS-native and simpler for many teams
- Kubernetes gives more flexibility and portability

For interview purposes, you can say:

- ECS is used for managed container orchestration on AWS
- Kubernetes is used when you want more advanced orchestration and portability

## 10. Simple interview explanation

You can say:

- I would containerize the services using Docker
- Push the images to ECR
- Deploy them on ECS Fargate
- Use ALB for traffic distribution
- Use Route 53 for DNS
- Use CloudWatch for monitoring
- Use IAM and security groups for secure networking

## 11. Important AWS terms to remember

- ECS: container orchestration
- Fargate: serverless containers
- ECR: container registry
- ALB: load balancer
- Route 53: DNS service
- CloudWatch: logging and monitoring
- VPC: virtual private cloud
- Security Group: firewall rules
- IAM: identity and access management
- Target Group: backend destination for ALB
- Task Definition: container runtime configuration

## 12. Simple notes for interview questions

### What is ECS?

- ECS is Amazon’s managed container service for running Docker containers.

### What is Fargate?

- Fargate lets you run containers without managing EC2 servers.

### What is ALB?

- ALB distributes traffic across multiple containers or services.

### What is Route 53?

- Route 53 is AWS DNS service used to map a domain to an application endpoint.

### What is CloudWatch?

- CloudWatch monitors logs, metrics, and alarms.

### What is a Task Definition?

- A task definition describes how a container should run, including CPU, memory, ports, and environment variables.

### What is vertical scaling?

- Vertical scaling increases resources of a single container.

### What is horizontal scaling?

- Horizontal scaling increases the number of container instances behind the load balancer.

## 13. DevOps topics you should learn for an enterprise role

### Infrastructure as Code (IaC)

- Use Terraform or AWS CloudFormation to create and manage AWS resources
- Helps you avoid manual setup and makes environments repeatable

### Terraform basics

- Understand providers, resources, variables, outputs, modules, and state files
- Example concepts:
  - `provider "aws"`
  - `resource "aws_ecs_cluster"`
  - `variable "environment"`
  - `output "alb_dns_name"`

### Environment variables and secrets

- Use environment variables for non-sensitive config
- Use AWS Secrets Manager or SSM Parameter Store for passwords, API keys, and tokens
- Never hardcode credentials in code or Docker images

### CI/CD

- Learn GitHub Actions, GitLab CI, or Jenkins
- Automate build, test, container image creation, and deployment
- Example pipeline stages:
  1. Checkout code
  2. Build and test
  3. Build Docker image
  4. Push to ECR
  5. Deploy to ECS

### Monitoring and observability

- Learn CloudWatch logs, metrics, alarms, and dashboards
- Add structured logging in your Spring Boot apps
- Use tracing tools such as OpenTelemetry or Zipkin

### Security basics

- Use IAM roles with least privilege
- Use security groups and NACLs properly
- Enable HTTPS with ACM and ALB
- Use private subnets for backend services

### Networking and DNS

- Understand public vs private subnets
- Understand NAT Gateway and internet gateway
- Understand how Route 53 maps domain names to ALB

### Containers and orchestration

- Docker basics: images, containers, Dockerfile, volumes, ports
- ECS basics: task definitions, services, clusters, load balancers
- Kubernetes basics: pods, deployments, services, ingress, ConfigMaps, Secrets

### Git and version control

- Understand branching strategies like main, dev, feature branches
- Use pull requests and code reviews

### Linux and shell basics

- Know commands like `docker`, `kubectl`, `curl`, `tail`, `grep`, `chmod`, and `systemctl`

## 14. Interview-ready DevOps explanation

You can say:

- I would use Docker to containerize the application
- Store images in ECR
- Deploy using ECS Fargate
- Use ALB for traffic distribution and Route 53 for DNS
- Use IAM, security groups, and private subnets for security
- Use CloudWatch for monitoring and alerts
- Use Terraform for infrastructure as code
- Use CI/CD pipelines to automate deployment

## 15. Beginner-friendly deployment checklist

- Create AWS account
- Create VPC and subnets
- Create ECR repositories
- Build and push Docker images
- Create ECS cluster
- Create task definitions
- Create ECS services
- Create ALB and target groups
- Attach services to ALB
- Create Route 53 record
- Enable CloudWatch logs
- Test the public URL
- Add Terraform for infrastructure provisioning
- Add CI/CD pipeline for deployment automation

## 16. Suggested DevOps learning roadmap

### Phase 1: Core basics

- Linux commands
- Networking basics
- Git and GitHub
- Docker basics

### Phase 2: Cloud fundamentals

- AWS core services
- IAM, VPC, EC2, S3, Route 53, CloudWatch
- Load balancing and DNS

### Phase 3: Containers and orchestration

- Dockerfiles
- ECS and Fargate
- Kubernetes basics

### Phase 4: Automation and IaC

- Terraform
- CI/CD with GitHub Actions or Jenkins
- Environment variables and secrets

### Phase 5: Monitoring and security

- CloudWatch alarms
- Logging and tracing
- IAM least-privilege and SSL/TLS

### Phase 6: Real-world practice

- Deploy a small app to AWS
- Add monitoring and alerts
- Practice explaining your architecture in interviews
