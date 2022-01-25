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
                    example = env.STAGE_NAME
                    println "Stage: ${example}"
                    if (params.buildTool == 'gradle') {
                        def ejecutar = load 'gradle.groovy'
                        ejecutar.call();
                        println "Stage2: ${example}"
                    } else {
                        def ejecutar = load 'maven.groovy'
                        ejecutar.call();
                        echo env.STAGE
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
               slackSend (color:"#FF0000",message: "[Ricardo Quiroga] [${env.JOB_NAME}] [${params.buildTool}] Ejecución fallida en stage ${example}")
               println "Stage3: ${example}"
            }
    }
}
