
def call() {
    stage('Build & Test') {
        sh './gradlew clean build'
        return ${env.STAGE_NAME}
    }
    stage('Sonar') {
        env.STAGE = "Sonar"
        println "Stage: ${env.STAGE_NAME}"
        return ${env.STAGE_NAME}
    }
    stage('Run') {
        env.STAGE = "Run"
        println "Stage: ${env.STAGE_NAME}"
        return ${env.STAGE_NAME}
    }
    stage('Test') {
        env.STAGE = "Test"
        println "Stage: ${env.STAGE_NAME}"
        return ${env.STAGE_NAME}
    }
    stage('Nexus') {
        env.STAGE = "Nexus"
        println "Stage: ${env.STAGE_NAME}"
        return ${env.STAGE_NAME}
    }
}

return this;