resource "aws_secretsmanager_secret" "jwt_secret" {
  name = "zenbank/jwt-secret"
}

resource "aws_secretsmanager_secret_version" "jwt_secret_value" {
  secret_id     = aws_secretsmanager_secret.jwt_secret.id
  secret_string = "change-me-in-production"
}
