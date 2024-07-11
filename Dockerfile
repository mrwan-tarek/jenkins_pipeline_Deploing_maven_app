FROM openjdk:8-jre-alpine

EXPOSE 8090

COPY ./target/my-app-*.jar /usr/app/
WORKDIR /usr/app

CMD java -jar my-app-*.jar
