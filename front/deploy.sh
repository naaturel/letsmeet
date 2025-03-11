#!/bin/sh
docker rm $(docker stop $(docker ps -a -q --filter ancestor=letsmeet --format="{{.ID}}"))
docker build -t letsmeet .
docker run -d -p 8080:8080 letsmeet