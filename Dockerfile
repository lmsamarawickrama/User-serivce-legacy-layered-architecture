FROM openjdk:8-jdk-alpine
MAINTAINER saliam.com
COPY target/smartbids-user-layered-0.0.1-SNAPSHOT.jar smartbids-user-layered-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/smartbids-user-layered-0.0.1-SNAPSHOT.jar"]