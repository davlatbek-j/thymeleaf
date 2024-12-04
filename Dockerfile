# Start with a base image containing Java runtime
FROM ubuntu:latest

# Add a volume pointing to /tmp
VOLUME /tmp

# run in path 'thymeleaf'
RUN mkdir /thymeleaf && mkdir photo-uploads && apt install openjdk-17-jdk openjdk-17-jre

#WORKDIR /thymeleaf

# Copy the project’s jar to the container
COPY target/thymeleaf-1.jar app.jar

# Expose port
EXPOSE 1984

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]