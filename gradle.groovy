env.STAGE="hello"
def call() {
    stage('Build & Test') {
        env.STAGE = "Build & Test"
        sh './gradlew clean build'
    }
    stage('Sonar') {
        env.STAGE = "Sonar"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Run') {
        env.STAGE = "Run"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Test') {
        env.STAGE = "Test"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Nexus') {
        env.STAGE = "Nexus"
        println "Stage: ${env.STAGE_NAME}"
    }
}

return this;