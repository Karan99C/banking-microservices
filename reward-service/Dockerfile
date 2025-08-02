# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/reward-service-0.0.1-SNAPSHOT.jar reward-service.jar


# Expose the service port
EXPOSE 8083

# Define entrypoint
ENTRYPOINT ["java", "-jar", "reward-service.jar"]



