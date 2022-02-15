FROM ubuntu
RUN apt-get update -y && apt-get install maven -y && apt-get install openjdk-11-jdk -y
COPY /demo /opt/app
WORKDIR /opt/app
RUN mvn clean package -DskipTests
ENTRYPOINT ["java", "-jar", "/opt/app/target/demo.jar"]