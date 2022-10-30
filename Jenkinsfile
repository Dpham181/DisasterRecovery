pipeline {
    agent any
    environment {
		DockerHub_Authentication=credentials('Docker-hub-Auth1')
	}
    tools {
      maven 'mvn' 
    }
  
    stages {
        stage('git check out and maven build') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Dpham181/excali']]])
               bat 'mvn clean install'
            }
        }
        
          stage('docker build image') {
            steps {
              bat 'docker  build -t dpham181/calitour .' 
            }
        }
        
             stage('docker deploy to localhost') {
            steps {
              bat 'docker run -d -p 8081:8083 dpham181/calitour' 
            }
        }
        
         stage('docker hub authentication ') {

			steps {
				bat 'echo %DockerHub_Authentication_PSW%| docker login -u %DockerHub_Authentication_USR% --password-stdin'
			}
		}

		stage('docker push to docker hub') {

			steps {
				bat 'docker push  dpham181/calitour'
			}
		}
        
   }    
}