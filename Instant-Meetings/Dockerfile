FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8.1-openjdk-17-slim
COPY --from=build /target/Instant-Meetings-0.0.1-SNAPSHOT.jar Instant-Meetings.jar
EXPOSE 8081
ENTRYPOINT [ "java","-jar","Instant-Meetings.jar" ] 