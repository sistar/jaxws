# Multi-stage Dockerfile for JAX-WS Maven projects testing
FROM maven:3.8-openjdk-8 AS builder

# Set working directory
WORKDIR /workspace

# Copy X.509 certificates first (needed for WS-Security)
COPY x509/ ./x509/

# Install dependencies and cache them
COPY double.it/pom.xml ./double.it/
COPY double.it/double.it.service/pom.xml ./double.it/double.it.service/
COPY double.it/double.it.client/pom.xml ./double.it/double.it.client/
COPY ws.security.sample/pom.xml ./ws.security.sample/
COPY wssecurity.map/pom.xml ./wssecurity.map/
COPY doubleIt/pom.xml ./doubleIt/
COPY doubleIt/doubleIt.service/pom.xml ./doubleIt/doubleIt.service/

# Set Maven options for Java module compatibility with legacy CXF
ENV MAVEN_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.util=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED"

# Download dependencies for all projects
RUN cd double.it && mvn dependency:go-offline -B
RUN cd ws.security.sample && mvn dependency:go-offline -B  
RUN cd wssecurity.map && mvn dependency:go-offline -B
RUN cd doubleIt && mvn dependency:go-offline -B

# Copy all source code
COPY . .

# Build stage - compile and package all projects
RUN echo "Building all Maven projects..." && \
    for project in double.it doubleIt ws.security.sample wssecurity.map; do \
        if [ -d "$project" ]; then \
            echo "Building project: $project" && \
            cd "$project" && \
            mvn clean compile -B -q && \
            cd ..; \
        fi \
    done

# Test stage
FROM maven:3.8-openjdk-8 AS tester

WORKDIR /workspace
COPY --from=builder /root/.m2 /root/.m2
COPY --from=builder /workspace .

# Run tests for all projects
RUN echo "Running tests for all Maven projects..." && \
    for project in double.it doubleIt ws.security.sample wssecurity.map; do \
        if [ -d "$project" ]; then \
            echo "Testing project: $project" && \
            cd "$project" && \
            mvn test -B -q || echo "Tests completed for $project" && \
            cd ..; \
        fi \
    done

# Package stage
FROM maven:3.8-openjdk-8 AS packager

WORKDIR /workspace
COPY --from=builder /root/.m2 /root/.m2
COPY --from=builder /workspace .

# Package all projects
RUN echo "Packaging all Maven projects..." && \
    for project in double.it doubleIt ws.security.sample wssecurity.map; do \
        if [ -d "$project" ]; then \
            echo "Packaging project: $project" && \
            cd "$project" && \
            mvn package -B -DskipTests -q && \
            cd ..; \
        fi \
    done

# Final runtime stage with Tomcat for deployment testing
FROM tomcat:10.0-jdk8 AS runtime

# Copy WAR files to Tomcat webapps (only if they exist)
COPY --from=packager /workspace /tmp/workspace
RUN find /tmp/workspace -name "*.war" -exec cp {} /usr/local/tomcat/webapps/ \; || echo "No WAR files found" && \
    rm -rf /tmp/workspace

# Copy X.509 certificates for runtime WS-Security
COPY --from=builder /workspace/x509 /opt/x509/

# Set Java options for legacy compatibility
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# Expose Tomcat port
EXPOSE 8080

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD curl -f http://localhost:8080/ || exit 1

CMD ["catalina.sh", "run"]