FROM maven:3.8.6-jdk-8

WORKDIR /project
COPY . .
RUN mvn clean install
ENV JAVA_OPTS "-Dspring.devtools.restart.enabled=true"
CMD mvn spring-boot:run