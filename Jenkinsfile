pipeline {
    agent any
    
    tools {
      maven 'mvn' 
    }
  
    stages {
    
        stage('git login and checkout') {
            steps {
               git branch: 'app-dev', credentialsId: '6b2cf960-165c-4d8e-a496-a268d7837b2d', url: 'git@github.com:Dpham181/DisasterRecovery.git'
               checkout scm
            }
        }
        
         stage('maven build project') {
            steps {
               bat 'mvn clean install'
            }
       }
       
       
         stage('docker build image') {
            steps {
              bat 'docker  build -t dpham181/disaster .' 
            }
        }
        
             stage('docker deploy to localhost') {
            steps {
              bat 'docker run -d -p 8081:8083 dpham181/disaster' 
            }
        }
        
        
         stage('docker hub authentication ') {

			steps {
				bat 'echo %DockerHub_Authentication_PSW%| docker login -u %DockerHub_Authentication_USR% --password-stdin'
			}
		}


		stage('docker push to docker hub') {

			steps {
				bat 'docker push  dpham181/disaster'
			}
		}
        
      
   }    
}