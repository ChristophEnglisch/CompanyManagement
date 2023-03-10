FROM gradle:jdk17 as build

RUN mkdir app
COPY . /app
WORKDIR /app

RUN gradle :document:build

FROM openjdk:17-jdk-slim

RUN apt-get update

RUN apt-get install tesseract-ocr tesseract-ocr-deu -y

COPY document/tessdata/ /app/tessdata/

RUN tesseract --list-langs

RUN tesseract -v

COPY --from=build /app/document/build/libs/*.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
