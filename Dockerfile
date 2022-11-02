FROM adoptopenjdk/openjdk8
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY /target/*.jar disaster.jar
CMD ["java","-jar","disaster.jar"]