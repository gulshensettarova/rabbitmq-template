FROM openjdk:17-jdk-slim
COPY rabbitmq-demo/build/libs/rabbitmq-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]