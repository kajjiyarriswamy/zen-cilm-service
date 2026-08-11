# AWS Interview Questions for This Project

## Basic questions

1. What is ECS?
   - ECS is AWS’s managed service for running and scaling containers.

2. What is Fargate?
   - Fargate runs containers without managing EC2 instances.

3. What is an Application Load Balancer?
   - ALB distributes traffic across multiple containers or services.

4. What is ECR?
   - ECR is AWS’s container image registry.

5. What is Route 53?
   - Route 53 is AWS DNS for mapping domains to deployed services.

6. What is CloudWatch?
   - CloudWatch is used for logs, metrics, and alarms.

7. What is a task definition?
   - It defines how a container should run, including ports, memory, CPU, and env values.

8. What is vertical scaling?
   - Vertical scaling increases the resources of an existing container.

9. What is horizontal scaling?
   - Horizontal scaling increases the number of running containers.

10. What is a security group?

- A security group controls inbound and outbound traffic to AWS resources.

## Scenario-based questions

1. How would you deploy this microservices project on AWS?
   - I would containerize the services, push images to ECR, deploy them on ECS Fargate, expose them through ALB, and use Route 53 and CloudWatch.

2. Why use a load balancer?
   - To distribute traffic and improve availability and scalability.

3. Why use CloudWatch?
   - To monitor logs, errors, resource usage, and application health.

4. Why use ECS instead of running containers on EC2?
   - ECS with Fargate is simpler and reduces server management overhead.

5. How would you make the system scalable?
   - By using horizontal scaling and adding more tasks behind the ALB.
