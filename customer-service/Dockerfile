# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/customer-service-0.0.1-SNAPSHOT.jar customer-service.jar


# Expose the service port
EXPOSE 8081

# Define entrypoint
ENTRYPOINT ["java", "-jar", "customer-service.jar"]