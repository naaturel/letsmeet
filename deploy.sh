#!/bin/sh

docker build -t letsmeet .
docker run -d -p 8080:8080 letsmeet