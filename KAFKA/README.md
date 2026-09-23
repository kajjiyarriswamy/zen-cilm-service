# Kafka Saga Sample Flow

This sample demonstrates a simple saga-style microservices flow across four services and an API gateway:

1. Order service creates an order and publishes an event to Kafka.
2. Inventory service consumes the event and reserves stock.
3. Payment service consumes the inventory success event and processes payment.
4. API Gateway routes requests to the services and validates JWT tokens.
5. Auth service issues and validates JWTs for protected endpoints.

## Run with Docker Compose

1. Make sure Docker Desktop is running.
2. From the KAFKA folder, run:
   - PowerShell: .\run-demo.ps1
3. Open the Swagger UI pages:
   - Auth: http://localhost:9090/swagger-ui/index.html
   - Order: http://localhost:8081/swagger-ui/index.html
   - Inventory: http://localhost:8082/swagger-ui/index.html
   - Payment: http://localhost:8083/swagger-ui/index.html
   - Gateway: http://localhost:9091/webjars/swagger-ui/index.html

## Demo flow

1. Login through the auth service:
   - POST http://localhost:9090/auth/login
   - Body: {"username":"alice","role":"ADMIN"}
2. Call a protected gateway route:
   - POST http://localhost:9091/orders?customerId=C1&productCode=LAPTOP&quantity=1&amount=100
   - Header: Authorization: Bearer <token>
3. Then check the created order:
   - GET http://localhost:9091/orders/1
   - Header: Authorization: Bearer <token>
4. Explore the downstream services directly or through the gateway.

## Notes

This is intentionally simple and clear for learning. It shows:

- API gateway routing
- JWT-based authentication
- service-to-service calls
- Swagger/OpenAPI documentation
- container-based startup for demos
- service discovery and enterprise-style deployment readiness
