# Use the official OpenJDK image from the Docker Hub
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file
COPY target/myapp.jar myapp.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "myapp.jar"]

