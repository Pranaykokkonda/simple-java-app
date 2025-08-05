# Stage 1: Build the application with JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy everything to the container
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean install -DskipTests

# Stage 2: Run the application with JDK 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/techeazy-devops-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 80

ENTRYPOINT ["java", "-jar", "app.jar"]
