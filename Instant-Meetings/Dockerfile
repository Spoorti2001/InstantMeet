FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /target/Instant-Meetings-0.0.1-SNAPSHOT.jar Instant-Meetings.jar
EXPOSE 8080
CMD ["java", "-jar", "Instant-Meetings.jar", "--server.port=${PORT}"]
