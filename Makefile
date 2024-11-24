all: build run

build:
	docker build . -t spring-boot-test:alpine

run:
	docker network create demo
	docker run -d -p 5432:5432 -e POSTGRES_USER=dbusername -e POSTGRES_PASSWORD=dbpassword -e POSTGRES_DB=mydb --name pg15 --network demo postgres:15-alpine
	docker run -d -p 8080:8080 --name spring-boot-test --network demo spring-boot-test:alpine

clean:
	- docker rm --force pg15 spring-boot-test
	- docker network rm demo
