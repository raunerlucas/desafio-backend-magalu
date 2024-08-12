FROM openjdk:22
LABEL authors="rauner.lucas"

WORKDIR /app

COPY target/rauner-lucas-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/rauner-lucas-0.0.1-SNAPSHOT.jar"]