# You can change this base image to anything else
# But make sure to use the correct version of Java
FROM adoptopenjdk/openjdk11:alpine-jre

# Simply the artifact path
ARG artifact=target/spring-boot-web.jar

WORKDIR /opt/app

COPY ${artifact} app.jar

# The "java" command is used to start a Java application, and the "-jar" option specifies that the application is packaged as an executable JAR file. The "app.jar" argument specifies the name of the JAR file that should be executed.
# "ENTRYPOINT" instruction sets the main process of the container to be the "java -jar app.jar" command, which means that when the container starts up, it will run the latest version of the JAR file that is included in the Docker image.
ENTRYPOINT ["java","-jar","app.jar"]
