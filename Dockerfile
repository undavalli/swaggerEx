FROM maven:3.6.3-jdk-8
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR  /tmp/
RUN mvn package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
