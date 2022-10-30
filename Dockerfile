FROM adoptopenjdk/openjdk8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY /target/*.jar DisasterRecovery.jar
CMD ["java","-jar","DisasterRecovery.jar"]