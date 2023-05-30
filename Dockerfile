#FROM eclipse-temurin:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]


#FROM eclipse-temurin:17-jdk-alpine as builder
#COPY mvnw pom.xml ./
#COPY .mvn .mvn
#COPY ./src ./src
#RUN ./mvnw clean install -DskipTests

#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /src
#ARG JAR_FILE=target/*.jar
#COPY --from=builder ${JAR_FILE} /src/app.jar
#ENTRYPOINT ["java", "-jar", "/src/app.jar"]

FROM maven:3.9.2-eclipse-temurin-17-alpine

