FROM openjdk:8-jre-alpine
MAINTAINER Vitor Gomes Miranda <vigmiranda@gmail.com>
VOLUME /tmp
ADD *.war build/libs/server-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
EXPOSE 8090
