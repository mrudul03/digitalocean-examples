FROM openjdk:latest
VOLUME /root/.m2
EXPOSE 8090
WORKDIR /agb/
ADD target/do-account-service-0.0.1-SNAPSHOT.jar /agb/do-account-service.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=staging","-jar","/agb/do-account-service.jar"]