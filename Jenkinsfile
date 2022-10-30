pipeline {
    agent any
    environment {
		DockerHub_Authentication=credentials('Docker-hub-Auth1')
	}
    tools {
      maven 'mvn' 
    }
  
    stages {
        stage('git login and checkout') {
            steps {
               git branch: 'app-dev', credentialsId: 'diepla1910', url: 'git@github.com:Dpham181/DisasterRecovery.git'
               checkout scm
            }
        }
         stage('maven build project') {
            steps {
               sh 'mvn clean install'
            }
       }
   }    
}