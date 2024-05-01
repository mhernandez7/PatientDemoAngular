FROM amazoncorretto:17-alpine-jdk
MAINTAINER MJJ
COPY build/libs/demo-0.0.1-SNAPSHOT.jar mgb-patient.jar
ENTRYPOINT ["java","-jar","/mgb-patient.jar"]
