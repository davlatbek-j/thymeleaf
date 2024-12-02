# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# run in path 'thymeleaf'
RUN mkdir /thymeleaf

WORKDIR /thymeleaf

# Copy the project’s jar to the container
COPY target/thymeleaf-1.jar /thymeleaf/app.jar

# Expose port
EXPOSE 1984

# Run the jar file
ENTRYPOINT ["java", "-jar", "thymeleaf/app.jar", "--spring.profiles.active=docker"]