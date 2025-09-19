FROM openjdk:21-jdk-slim
LABEL authors="dario"
COPY target/ispit-0.0.1-SNAPSHOT.jar dockerRestAPI.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dockerRestAPI.jar"]