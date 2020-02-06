# stage-0 for build
FROM maven:3-jdk-8
WORKDIR /tmp
## cache dependencies seperatly
## only runs if pom.xml changes
COPY pom.xml .
RUN mvn verify clean --fail-never
## build from source
COPY src/ ./src/
RUN mvn package spring-boot:repackage

# stage-1 for execution
FROM openjdk:8-jre-slim
WORKDIR /app
COPY --from=0 /tmp/target/d2s-api-*.jar /app/d2s-api.jar
ENTRYPOINT ["java","-jar","d2s-api.jar"]

EXPOSE 8080