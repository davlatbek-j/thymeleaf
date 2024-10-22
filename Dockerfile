# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# Copy the project’s jar to the container
COPY target/thymeleaf-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
