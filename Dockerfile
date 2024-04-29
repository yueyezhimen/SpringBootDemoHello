# Use the official maven/Java 8 image to create a build artifact.
# https://hub.docker.com/_/maven
FROM maven:3.6.0-jdk-8-slim as build

# Copy local code to the container image.
WORKDIR /app
COPY SpringBootDemo-0.0.1-SNAPSHOT.jar ./

# Build a release artifact.
#RUN mvn package -DskipTests
WORKDIR /app
# Run the web service on container startup.
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=80","-jar","/app/SpringBootPingPong-0.0.1-SNAPSHOT.jar"]