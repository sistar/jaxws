JAX-WS has evolved but its growth has slowed significantly:

  Current Status:
  - Removed from Java SE 11+ and moved to Jakarta XML Web Services under Jakarta EE
  - Now maintained by Eclipse Foundation as part of Jakarta EE ecosystem
  - Current specification is version 3.0

  Evolution Path:
  - Transitioned from Oracle's Java EE to Eclipse's Jakarta EE
  - API packages changed from javax.* to jakarta.*
  - Still actively maintained but with limited new feature development

  Market Reality:
  - SOAP/JAX-WS usage has declined significantly in favor of REST APIs
  - 2024 surveys show Jakarta REST (JAX-RS) is far more popular than SOAP-based services
  - Modern microservices and cloud-native applications typically use REST, GraphQL, or gRPC instead

  Summary: JAX-WS still evolves under Jakarta EE but it's essentially in maintenance mode. New projects
  rarely choose SOAP/JAX-WS over REST-based alternatives. Codebase represents legacy enterprise
  integration patterns that are still supported but no longer considered modern best practice.
