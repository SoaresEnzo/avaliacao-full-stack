FROM maven:3.8.6-eclipse-temurin-17-alpine as builder
WORKDIR /usr/src
COPY ./ ./
CMD ["mvn", "clean", "install"]

FROM amazoncorretto:17.0.4-alpine3.15
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY -from=builder /usr/src/target ./
EXPOSE 8080
CMD ["java", "-jar", "transferencias-0.0.1-SNAPSHOT.jar"]