FROM gradle:8.11.1-jdk17 AS build

WORKDIR /app

COPY . .

RUN gradle build --no-daemon --stacktrace -x test   

RUN ls -la /app/build/libs/

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /app/build/libs/microapp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]