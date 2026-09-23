# CI/CD Pipeline Notes

## Suggested pipeline flow

1. Checkout source code
2. Build all Spring Boot services with Maven
3. Run unit tests
4. Build Docker images
5. Push images to a container registry
6. Deploy to a staging environment
7. Run smoke tests
8. Promote to production

## Example GitHub Actions flow

```yaml
name: Build and Deploy

on:
  push:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: "17"
      - name: Build services
        run: |
          cd auth-service && mvn test
          cd ../order && mvn test
          cd ../inventory && mvn test
          cd ../payment && mvn test
          cd ../api-gateway && mvn test
```

## Enterprise value

This makes the project look more realistic for interviews because it shows:

- automated build verification
- repeatable deployment flow
- modern DevOps mindset
