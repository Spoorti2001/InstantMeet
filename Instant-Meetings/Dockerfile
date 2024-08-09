# Build stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Production stage
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/Instant-Meetings-0.0.1-SNAPSHOT.jar Instant-Meetings.jar
EXPOSE 8081
CMD ["java", "-jar", "Instant-Meetings.jar", "--server.port=${PORT}"]
