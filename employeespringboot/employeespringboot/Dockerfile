# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar employeespringboot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "employeespringboot.jar"]

