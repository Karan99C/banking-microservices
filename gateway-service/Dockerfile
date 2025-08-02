# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/gateway-service-0.0.1-SNAPSHOT.jar gateway-service.jar


# Expose the service port
EXPOSE 8085

# Define entrypoint
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]