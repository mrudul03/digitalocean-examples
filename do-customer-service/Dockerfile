FROM openjdk:latest
VOLUME /root/.m2
EXPOSE 8080
WORKDIR /agb/
ADD target/do-customer-service-0.0.1-SNAPSHOT.jar /agb/do-customer-service.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=staging","-jar","/agb/do-customer-service.jar"]