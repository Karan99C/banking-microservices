# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar


# Expose the service port
EXPOSE 8082

# Define entrypoint
ENTRYPOINT ["java", "-jar", "transaction-service.jar"]