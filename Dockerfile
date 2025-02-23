FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
ADD ./target/microservice-client-0.0.1-SNAPSHOT.jar microservice-client.jar
ENTRYPOINT ["java", "-jar", "microservice-client.jar"]
