pipeline {
	agent any
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
                    } else {
                        def ejecutar = load 'maven.groovy'
                        ejecutar.call();
                    }
                }
			}
		}

	}
}
