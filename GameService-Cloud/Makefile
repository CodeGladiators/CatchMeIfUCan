
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar GameServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/org.restlet.ext.servlet.jar:dist/app.jar api.GameServer

compile: 
	javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/org.restlet.ext.servlet.jar -d build \
	src/api/*.java

run:
	echo Starting Service at:  http://localhost:8081
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/org.restlet.ext.servlet.jar api.GameServer

docker-build: app
	docker build -t nilamdeka14/gameserver .
	docker images

docker-clean:
	docker stop gameserver
	docker rm gameserver
	docker rmi gameserver

docker-run:
	docker run --name gameserver -td gameserver
	docker ps

docker-run-host:
	docker run --name gameserver -td --net=host gameserver
	docker ps

docker-run-bridge:
	docker run --name gameserver -td -p 80:8081 gameserver
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop gameserver
	docker rm gameserver

docker-shell:
	docker exec -it gameserver bash 
	
