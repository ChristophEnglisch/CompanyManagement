FROM gradle:jdk17 as build

RUN mkdir app
COPY . /app
WORKDIR /app

RUN gradle :hiring:build --stacktrace

FROM openjdk:17-jdk-slim

COPY --from=build /app/hiring/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
