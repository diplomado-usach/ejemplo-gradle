pipeline {
	agent any
	parameters {
        choice(name: 'buildTool', choices:['gradle', 'maven'],  description: 'indicar build tools')
    }
    environment{
    STAGE = ''
    }

	stages {
		stage('Pipeline') {
			steps {
                script{
                    println params.buildTool
                    if (params.buildTool == 'gradle') {
                        def ejecutar = load 'gradle.groovy'
                        ejecutar.call();
                    } else {
                        def ejecutar = load 'maven.groovy'
                        ejecutar.call();
                    }
                }
			}
		}

	}
	post {
            success {
                slackSend (color:'GREEN',message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución exitosa")
            }
            failure {
               slackSend (color:'RED',message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución fallida en stage ${STAGE}")
            }
    }
}
