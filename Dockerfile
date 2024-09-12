# Step 1: Use an official OpenJDK runtime as a parent image
FROM openjdk:20-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Maven build output (JAR file) from the local machine into the container
COPY target/my-java-app-1.0-SNAPSHOT.jar app.jar

# Step 4: Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Step 5: Set the command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
