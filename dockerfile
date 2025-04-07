
# Etapa 1: build
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: runtime
FROM openjdk:17-jdk-slim
ARG APP_NAME="docker-0.0.1-SNAPSHOT.jar"
COPY --from=build /app/target/${APP_NAME} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]