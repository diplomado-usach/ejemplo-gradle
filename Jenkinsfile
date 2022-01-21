pipeline {
	agent any
	stages {
		stage('Build & Test') {
			steps {
				sh './gradle clean build'
			}
		}
		stage('Sonar') {
			environment {
                scannerHome = tool 'SonarQubeScanner'
            }
            steps {
            	withSonarQubeEnv('sonarqube') {
            		sh '${scannerHome}/bin/sonar-scanner'
                }
            }
		}
		stage('Run') {
			steps {
				sh 'JENKINS_NODE_COOKIE=dontKillMe nohup bash gradle bootRun &'
			}
		}
		stage('Nexus') {
			steps {
            	nexusArtifactUploader artifacts: [
            		[
            		    artifactId: 'DevOpsUsach2020',
            			classifier: '',
            			file: 'build/DevOpsUsach2020-0.0.1.jar',
            			type: 'jar'
            		]
            	],
            	credentialsId: 'nexus_local_credentials',
            	groupId: 'com.devopsusach2020',
            	nexusUrl: 'localhost:8081',
            	nexusVersion: 'nexus3',
            	protocol: 'http',
            	repository: 'test-repo',
            	version: '0.0.1'
            }
       }
	}
}
