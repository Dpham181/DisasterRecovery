pipeline {
    agent any
    environment {
		
	}
    tools {
      maven 'mvn' 
    }
  
    stages {
        stage('git login and checkout') {
            steps {
               git branch: 'diep-dev', credentialsId: 'diepla1910', url: 'git@github.com:Dpham181/DisasterRecovery.git'
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