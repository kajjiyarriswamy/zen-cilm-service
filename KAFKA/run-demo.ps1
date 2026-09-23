Write-Host "Starting Kafka..."
docker compose up -d zookeeper kafka

Write-Host "Starting services..."
docker compose up -d auth-service order-service inventory-service payment-service api-gateway

Write-Host "Services are starting. Use the following URLs:"
Write-Host "- Auth: http://localhost:9090/swagger-ui/index.html"
Write-Host "- Order: http://localhost:8081/swagger-ui/index.html"
Write-Host "- Inventory: http://localhost:8082/swagger-ui/index.html"
Write-Host "- Payment: http://localhost:8083/swagger-ui/index.html"
Write-Host "- Gateway: http://localhost:9091/webjars/swagger-ui/index.html"
