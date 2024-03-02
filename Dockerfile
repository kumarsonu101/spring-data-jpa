FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/spring-data-jpa.jar.original
WORKDIR /app
COPY ./target/spring-data-jpa.jar.original spring-data-jpa.jar.original
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar.original"]
 