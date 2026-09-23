# API Gateway security routing demo

This module exposes a single entry point for the Kafka sample services:

- Auth service: http://localhost:9090
- Order service: http://localhost:8081
- Inventory service: http://localhost:8082
- Payment service: http://localhost:8083
- API gateway: http://localhost:9091

## Routing rules

- /auth/\*\* -> auth-service
- /orders/\*\* -> order-service
- /inventory/\*\* -> inventory-service
- /payments/\*\* -> payment-service

## Security behavior

The gateway validates a Bearer JWT before allowing traffic to the business services.

## Demo flow

1. Start the auth service
   - mvn spring-boot:run
2. Start the business services
   - order, inventory, payment
3. Start the gateway
   - mvn spring-boot:run
4. Get a token
   - POST http://localhost:9091/auth/login
   - body: {"username":"alice","role":"ADMIN"}
5. Call a protected endpoint
   - GET http://localhost:9091/orders/123
   - Header: Authorization: Bearer <token>

If the token is missing or invalid, the gateway returns 401 Unauthorized.
