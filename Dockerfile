FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/spring-data-jpa.jar
WORKDIR /app
COPY ${JAR_FILE} /app/spring-data-jpa.jar
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar"]