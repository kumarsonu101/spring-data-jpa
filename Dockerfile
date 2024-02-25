FROM  openjdk:17-oracle
WORKDIR spring-data-jpa
COPY --from=build target/*spring-data-jpa.jar spring-data-jpa.jar
ENTRYPOINT ["java", "-jar", "spring-data-jpa.jar"]