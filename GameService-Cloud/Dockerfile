FROM openjdk
EXPOSE 8080
ADD ./dist/app.jar /srv/app.jar
ADD ./dist/restlet.jar /srv/restlet.jar
ADD ./dist/restlet-json.jar /srv/restlet-json.jar
ADD ./dist/json.jar /srv/json.jar
ADD ./dist/org.restlet.ext.servlet.jar /srv/org.restlet.ext.servlet.jar

CMD java -cp /srv/restlet.jar:/srv/restlet-json.jar:/srv/json.jar:/srv/org.restlet.ext.servlet.jar:/srv/app.jar api.GameServer