docker build -t orders:0.0.1-snapshot .
docker build -t catalog:0.0.1-snapshot .


mvn clean package dockerfile:build   

docker-compose -f docker/docker-compose.yml up   