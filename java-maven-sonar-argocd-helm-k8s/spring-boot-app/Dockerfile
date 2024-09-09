# Use Maven for building the project, based on an OpenJDK image
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project and create the JAR file
RUN mvn clean package

# Use a lightweight OpenJDK image to run the application
FROM adoptopenjdk/openjdk11:alpine-jre

# Copy the JAR file from the previous stage to the final image
COPY --from=build /app/target/spring-boot-web.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


