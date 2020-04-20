FROM openjdk:8-jre-alpine
ADD target/client-account.jar app.jar
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]
ENTRYPOINT exec java $JAVA_OPTS $DEBUG_OPTS $SPRING_PROFILE -jar /app.jar
