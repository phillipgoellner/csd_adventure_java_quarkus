#!/bin/sh

./mvnw package
pgrep -f quarkus.http.port=80 | xargs kill -9
java -Dquarkus.http.port=80 -jar target/quarkus-app/quarkus-run.jar &
