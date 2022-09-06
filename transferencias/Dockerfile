FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /usr/src
COPY ./ ./
RUN mvn clean install
EXPOSE 8080
ENTRYPOINT ["java" ,"-jar" ,"transferencias-0.0.1-SNAPSHOT.jar"]