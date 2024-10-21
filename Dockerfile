# Step 1: Use an official JDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the jar file into the container at /app
COPY target/thymeleaf-0.0.1-SNAPSHOT.jar /app/app.jar

# Step 4: Expose the port your app runs on (default Spring Boot is 8080)
EXPOSE 1984

# Step 5: Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]