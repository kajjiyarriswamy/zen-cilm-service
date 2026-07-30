# Kafka Saga Sample Flow

This sample demonstrates a very simple saga-like flow across three services:

1. Order service creates an order and publishes an event to Kafka.
2. Inventory service consumes the event and reserves stock.
3. Payment service consumes the inventory success event and processes payment.
4. If payment fails, a compensation event is published so the order and inventory can be marked as failed/compensated.

## How to run

1. Start Kafka locally.
2. Run each service:
   - order service: mvn spring-boot:run
   - inventory service: mvn spring-boot:run
   - payment service: mvn spring-boot:run
3. Create an order:
   - POST http://localhost:8081/orders?customerId=C1&productCode=LAPTOP&quantity=1&amount=100

## Notes

This is intentionally simple and clear for learning. In a real system, you would usually use:

- idempotency
- outbox pattern
- dead-letter topics
- a proper saga orchestrator or choreography with retries
