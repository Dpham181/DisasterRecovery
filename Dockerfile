FROM adoptopenjdk/openjdk8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY /target/*.jar disasterRecovery.jar
CMD ["java","-jar","disasterRecovery.jar"]