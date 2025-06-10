# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a JAX-WS educational codebase demonstrating SOAP web services using Apache CXF 2.2.3 and Java 1.6. It contains multiple example projects showcasing different aspects of web service development, with a heavy focus on WS-Security implementations.

## Build System

Uses **Maven** with multi-module project structure. Key Maven commands:

### Basic Build Commands
```bash
# Build all modules
mvn clean compile

# Build with tests
mvn clean test

# Package projects
mvn clean package

# Generate sources from WSDL
mvn generate-sources
```

### Module-Specific Commands
```bash
# Deploy WAR to Tomcat (requires Tomcat manager setup)
cd double.it/double.it.service
mvn tomcat:deploy

# Undeploy from Tomcat  
mvn tomcat:undeploy

# Run client application
cd double.it/double.it.client
mvn exec:java
```

### WSDL Code Generation
```bash
# CXF wsdl2java code generation (runs automatically during generate-sources)
mvn cxf:wsdl2java
```

## Project Modules Architecture

### Core Service Modules
- **SimpleWS/**: Basic JAX-WS service using `Endpoint.publish()` for standalone deployment
- **double.it/**: Multi-module CXF project with service and client modules, demonstrates contract-first development
- **ws.security.sample/**: WS-Security implementation with digital signatures and X.509 certificates
- **wssecurity.map/**: Alternative WS-Security configuration approach

### Client Modules  
- **SimpleWSClient/**: Basic client for SimpleWS using dynamic proxy pattern
- **double.it.client/**: CXF-based client with Spring integration

## Key Technologies

- **Apache CXF 2.2.3**: Primary JAX-WS implementation
- **WSS4J 1.5.8**: WS-Security implementation
- **Spring Framework**: Configuration and dependency injection
- **JUnit 4.4**: Testing framework
- **SoapUI**: SOAP service testing (`.xml` project files)

## Configuration Patterns

### Service Deployment
- **Standalone**: `Endpoint.publish()` for development/testing
- **Web Container**: WAR deployment with `beans.xml` Spring configuration
- **CXF Servlet**: Mapped to `/services/*` in web.xml

### Security Configuration
- X.509 certificates and keystores located in `/x509/` directory
- Password callback handlers for WS-Security
- Security interceptors configured in `beans.xml`
- Property files for security configuration (e.g., `server_sign.properties`)

## Testing

### Test Execution
```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=SigningTest

# Run SoapUI tests (requires SoapUI installation)
# Use Hello-soapui-project.xml files with SoapUI tool
```

### Test Structure
- Unit tests in each module's `src/test/java`
- Integration tests for WS-Security functionality
- SoapUI project files for SOAP service testing

## Security Setup

Certificate management commands are documented in `/x509/readme.txt`. The project uses mutual authentication with client and server certificates for WS-Security demonstrations.

## Development Notes

- Java 1.6 compatibility required (legacy project)
- German language comments and documentation present
- Educational/workshop material structure
- Multiple similar implementations showing different approaches
- Eclipse WTP integration configured via Maven plugin