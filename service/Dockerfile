FROM openjdk:17-alpine
VOLUME /tmp
WORKDIR /app
COPY target/telikos-activityplanworkflow-service.jar /app/
ENTRYPOINT ["java", "-jar", "telikos-activityplanworkflow-service.jar"]
