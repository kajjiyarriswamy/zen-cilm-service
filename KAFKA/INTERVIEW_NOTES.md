# Interview Questions and Notes for the Microservices Demo

## Interview Questions with One-Line Answers

1. What is an API Gateway?
   - An API Gateway is a single entry point that routes requests to the appropriate microservice and handles cross-cutting concerns like authentication and logging.

2. Why use an API Gateway in microservices?
   - It simplifies client interactions, centralizes security, and reduces direct dependency on multiple service endpoints.

3. What is the role of an Auth Service?
   - The Auth Service issues and validates tokens so only authorized clients can access protected services.

4. What is JWT?
   - JWT is a compact token format used to securely transmit identity and authorization information between services and clients.

5. What is a microservice?
   - A microservice is an independently deployable service that focuses on one business capability.

6. What is the difference between monolithic and microservices architecture?
   - A monolith is one large application, while microservices split functionality into smaller independent services.

7. What is service-to-service communication?
   - It is communication between different microservices, usually through REST, messaging, or RPC.

8. Why use Kafka in this project?
   - Kafka helps decouple services by allowing events like order creation to be published and consumed asynchronously.

9. What is a saga pattern?
   - A saga pattern coordinates distributed transactions across services using a sequence of local transactions and compensating actions.

10. What is the purpose of the Order service?

- The Order service creates orders and triggers the workflow for inventory and payment processing.

11. What is the purpose of the Inventory service?

- The Inventory service checks and reserves stock for the requested product.

12. What is the purpose of the Payment service?

- The Payment service processes the payment for the order.

13. How do you secure microservices?

- By using authentication, authorization, JWTs, API gateways, and proper service-to-service validation.

14. What is Swagger/OpenAPI?

- Swagger/OpenAPI is a standard way to document and test REST APIs.

15. What is Docker Compose useful for?

- It allows multiple services to be started together with a single command for easier development and demo setup.

## Short Notes for Interview Discussion

- This project demonstrates real-world microservice concepts such as routing, authentication, service separation, and event-driven communication.
- The API Gateway acts as the front door for all requests.
- The Auth Service provides token-based security.
- The Order, Inventory, and Payment services represent a simple business workflow.
- Kafka is used to decouple the services and support asynchronous processing.
- Swagger makes the APIs easy to explore and explain during interviews.
- Docker Compose improves demo readiness and deployment simplicity.

## Good Interview Talking Points

- Start with the business flow: order -> inventory -> payment.
- Explain the role of each service clearly.
- Mention why gateway and auth are important in production.
- Highlight that the project is extensible for resilience, service discovery, monitoring, and deployment automation.
- Emphasize that the architecture now looks closer to an enterprise system with discovery, health checks, and API documentation.
