# Build Stage
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
# Download dependencies separately to leverage Docker cache
RUN mvn dependency:go-offline

COPY src ./src
# Compile and package without downloading dependencies
RUN mvn clean package -DskipTests

# Test Stage
FROM build AS test
RUN mvn test

# Deploy Stage
FROM openjdk:17-slim as deploy
WORKDIR /app
COPY --from=build /app/target/mirror-app-1.0-SNAPSHOT.jar /app/mirror-app.jar
EXPOSE 8080
CMD ["java", "-jar", "mirror-app.jar"]
