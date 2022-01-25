class BuildGradlePipeline {
    def STAGE

    BuildGradlePipeline(script) {
        stage('Build & Test') {
            this.STAGE = "Build & Test"
            sh './gradlew clean build'
        }
        stage('Sonar') {
            this.STAGE = "Sonar"
            println "Stage: ${script.env.STAGE_NAME}"
        }
        stage('Run') {
            this.STAGE = "Run"
            println "Stage: ${script.env.STAGE_NAME}"
        }
        stage('Test') {
            this.STAGE = "Test"
            println "Stage: ${script.env.STAGE_NAME}"
        }
        stage('Nexus') {
            this.STAGE = "Nexus"
            println "Stage: ${script.env.STAGE_NAME}"
        }
    }
}
return new BuildGradlePipeline(this);