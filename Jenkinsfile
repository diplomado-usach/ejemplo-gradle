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
	def subject = "[Ricardo Quiroga] '[${env.JOB_NAME}]'"
	def ok = "${subject} "+ params.buildTool + " Ejecución exitosa"
	def nook = "${subject} "+ params.buildTool + " Ejecución fallida enn stage ${STAGE}"
	post {
            success {
                slackSend (color:'GREEN',message: ok)
            }
            failure {
               slackSend (color:'RED',message: nook)
            }
    }
}
