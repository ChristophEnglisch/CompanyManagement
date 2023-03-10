FROM gradle:jdk17 as build

RUN mkdir app

COPY . /app

WORKDIR /app

RUN gradle :appointment:build --stacktrace

FROM openjdk:17-jdk-slim

COPY --from=build /app/appointment/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
