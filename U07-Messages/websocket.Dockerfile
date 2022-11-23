FROM openjdk:17-slim-bullseye

RUN apt-get update && apt-get install -y maven
COPY ./WebSocket /WebSocket
RUN cd /WebSocket && mvn package

ENTRYPOINT ["java", "-jar","/WebSocket/target/WebSocket-0.0.1-SNAPSHOT.jar"]