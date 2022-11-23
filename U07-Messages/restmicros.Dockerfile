FROM openjdk:17-slim-bullseye

RUN apt-get update && apt-get install -y maven
COPY ./RestMicroS /RestMicroS
RUN cd /RestMicroS && mvn package

ENTRYPOINT ["java", "-jar","/RestMicroS/target/RestMicroS-0.0.1-SNAPSHOT.jar"]