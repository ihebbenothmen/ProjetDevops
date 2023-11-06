FROM openjdk:11-jre-slim
EXPOSE 8089
WORKDIR /app

RUN apt-get update && apt-get install -y curl
RUN curl -o kaddem-1.0.jar -L "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/spring/kaddem/1.0/kaddem-1.0.jar"

ENTRYPOINT ["java", "-jar", "kaddem-1.0.jar"]