FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8089
ADD target/kaddem-1.4.jar kaddem-1.4.jar
ENTRYPOINT [ "java", "-jar", "kaddem-1.4.jar"]
