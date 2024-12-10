FROM gradle:7.5.1-jdk17 AS build

COPY . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM amazoncorretto:17-alpine

EXPOSE 8080

COPY --from=build /home/gradle/src/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]

