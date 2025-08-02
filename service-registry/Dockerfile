
# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar


# Expose the service port
EXPOSE 8761

# Define entrypoint
ENTRYPOINT ["java", "-jar", "service-registry.jar"]