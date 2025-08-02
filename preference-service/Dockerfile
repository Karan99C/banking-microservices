# Use OpenJDK base image
FROM openjdk:21-jdk-slim


# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/preference-service-0.0.1-SNAPSHOT.jar preference-service.jar


# Expose the service port
EXPOSE 8086

# Define entrypoint
ENTRYPOINT ["java", "-jar", "preference-service.jar"]



