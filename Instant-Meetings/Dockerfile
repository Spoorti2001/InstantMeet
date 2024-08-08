# Build stage
FROM maven:3.8.3-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17-slim
COPY --from=build /app/target/Instant-Meetings-0.0.1-SNAPSHOT.jar /app/Instant-Meetings.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/Instant-Meetings.jar", "--server.port=8081"]
