FROM openjdk:8-jre-alpine

ADD server/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app.jar"]
