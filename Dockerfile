FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY target .
RUN mvn install -Dmaven.test.skip

CMD mvn spring-boot:run