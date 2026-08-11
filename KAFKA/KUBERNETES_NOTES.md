# Kubernetes Notes

## Why Kubernetes helps

- Scales services independently
- Supports rolling updates and self-healing
- Improves resilience and deployment automation

## Typical deployment model

- Deploy each Spring Boot service as a separate pod
- Use a Service for internal routing
- Use an Ingress for external access
- Use ConfigMaps and Secrets for environment values

## Interview talking point

Kubernetes makes this microservices architecture production-ready by handling scaling, resilience, and deployment automation.
