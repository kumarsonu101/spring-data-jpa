FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/spring-data-jpa.jar
COPY ${JAR_FILE} spring-data-jpa.jar
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar"]
 