FROM eclipse-temurin:17-jdk-alpine AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN ./mvnw -f $HOME/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=/usr/app/target/*.jar
COPY --from=build $JAR_FILE /app/runner.jar
ENV DB_HOST=pg15
ENV DB_PORT=5432
ENV DB_NAME=mydb
ENV DB_USER=dbusername
ENV DB_PASS=dbpassword
EXPOSE 8080
ENTRYPOINT java -jar /app/runner.jar

