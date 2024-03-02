FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
ARG JAR_FILE=target/spring-data-jpa.jar
ADD ${JAR_FILE} spring-data-jpa.jar
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar"]