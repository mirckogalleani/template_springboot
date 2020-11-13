#BUILDER PATRON DOCKER / JAVA
FROM maven:3.6.3-jdk-8-openj9 as BUILD_IMAGE
WORKDIR /srv/app/
ADD src src/
ADD pom.* ./
RUN mvn package | grep -i BUILD

FROM us.gcr.io/compliance-sec/jre-8:k8susr130016
WORKDIR /app/
COPY --from=BUILD_IMAGE /srv/app/target/*.jar app.jar
ENTRYPOINT exec java \
    -XX:+UnlockExperimentalVMOptions \
    -XX:+UseCGroupMemoryLimitForHeap \
    -Dspring.profiles.active=$SERVICE_ENV \
    -Dfile.encoding=UTF-8 \
    -Duser.timezone=America/Santiago \
    -jar /app/app.jar
