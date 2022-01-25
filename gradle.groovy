STAGE= ""
def call() {
    stage('Build & Test') {
        STAGE = "Build & Test"
        sh './gradlew clean build'
    }
    stage('Sonar') {
        STAGE = "Sonar"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Run') {
        STAGE = "Run"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Test') {
        STAGE = "Test"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Nexus') {
        STAGE = "Nexus"
        println "Stage: ${env.STAGE_NAME}"
    }
}

return this;