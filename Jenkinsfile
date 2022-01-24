pipeline {
	agent any
	parameters {
      choice choices: ['gradle', 'maven'], description: 'indicar herramienta de construccion', name: 'buildTool'
    }
	stages {
		stage('Pipeline') {
			steps {
				println params.buildTool
				if(params.buildTool == "gradle"){
                def ejecutar = load 'gradle.groovy'
                ejecutar.call();
				}else{
				 def ejecutar = load 'maven.groovy'
                 ejecutar.call();
				}
			}
		}

	}
}
