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

FROM maven:3.9.2-eclipse-temurin-17-alpine as builder

WORKDIR /workdir/server
COPY pom.xml /workdir/server/pom.xml
RUN mvn dependency:go-offline

COPY src /workdir/server/src
RUN mvn install -DskipTests

FROM builder as dev


FROM eclipse-temurin:17-jdk-alpine as production
WORKDIR /src
ARG JAR_FILE=/workdir/server/target/*.jar
COPY --from=builder ${JAR_FILE} /src/app.jar
ENTRYPOINT ["java", "-jar", "/src/app.jar"]
