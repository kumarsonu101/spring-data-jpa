FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/spring-data-jpa.jar
WORKDIR /app
COPY ./target/spring-data-jpa.jar spring-data-jpa.jar
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar"]
