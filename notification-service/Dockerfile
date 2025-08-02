# Use OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/notification-service-0.0.1-SNAPSHOT.jar notification-service.jar


# Expose the service port
EXPOSE 8084

# Define entrypoint
ENTRYPOINT ["java", "-jar", "notification-service.jar"]