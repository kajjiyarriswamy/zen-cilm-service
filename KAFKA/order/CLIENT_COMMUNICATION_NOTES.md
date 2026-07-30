# Client Communication Demo for Order Service

This module shows four common ways an order service can call another service:

1. RestTemplate
2. WebClient
3. Feign Client
4. Feign Client with a simple interface-based contract

## 1. RestTemplate

- Good for simple synchronous calls.
- Uses `getForEntity(...)` or `postForEntity(...)`.
- Best for older Spring projects or quick demos.

## 2. WebClient

- Reactive and non-blocking.
- Good for modern Spring Boot applications.
- Useful when you want better scalability for many requests.

## 3. Feign Client

- Lets you define HTTP clients with Java interfaces.
- Reduces boilerplate code.
- Great for service-to-service communication in microservices.

## 4. Feign Client + interface-based design

- Keeps the HTTP contract clean and reusable.
- Makes the service code easier to test.
- Fits well with Spring Cloud microservice architecture.

## Demo endpoints

- `/client-demo/rest-template?url=http://localhost:8082/payments/health`
- `/client-demo/webclient?url=http://localhost:8082/payments/health`
- `/client-demo/feign/payment`
- `/client-demo/feign/inventory`

## Questions with one-line answers

- What is RestTemplate used for? It is used for simple synchronous HTTP calls between services.
- What is WebClient used for? It is used for reactive and non-blocking HTTP communication.
- What is Feign Client used for? It is used to define HTTP clients with simple Java interfaces.
- Which client is more modern: RestTemplate or WebClient? WebClient is more modern and non-blocking.
- Why use Feign in microservices? It reduces boilerplate and keeps service-to-service calls clean.
