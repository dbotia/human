FROM adoptopenjdk/openjdk8:latest
COPY human-0.0.1-SNAPSHOT.jar /usr/src/bootdocker/human-0.0.1-SNAPSHOT.jar
WORKDIR /usr/src/bootdocker
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/usr/src/bootdocker/human-0.0.1-SNAPSHOT.jar"]
