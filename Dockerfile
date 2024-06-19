FROM openjdk:17-alpine
WORKDIR /usr/src/app
ARG JAR_FILE=zzansuni-api-server/app/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Duser.timezone=Asia/Seoul", "-jar", "app.jar"]