FROM khipu/openjdk17-alpine

RUN mkdir /app

COPY target/fullstack-challenge-api-0.0.1-SNAPSHOT.jar /app/fullstack-challenge-api-0.0.1-SNAPSHOT.jar

EXPOSE 8080

WORKDIR /app

CMD ls -l && java -jar fullstack-challenge-api-0.0.1-SNAPSHOT.jar