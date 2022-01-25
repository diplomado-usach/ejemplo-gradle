pipeline {
	agent any
	environment{
        STAGE = ''
    }
	parameters {
        choice(name: 'buildTool', choices:['gradle', 'maven'],  description: 'indicar build tools')
    }
	stages {
		stage('Pipeline') {
			steps {
                script{
                    println params.buildTool
                    if (params.buildTool == 'gradle') {
                        def ejecutar = load 'gradle.groovy'
                        ejecutar.call();
                        println "Stage2: ${STAGE}"
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
                slackSend (color:"#008000",message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución exitosa")
            }
            failure {
               slackSend (color:"#FF0000",message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución fallida en stage ${STAGE}")
               println "Stage3: ${example}"
            }
    }
}
