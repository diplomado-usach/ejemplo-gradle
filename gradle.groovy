def call() {
    stage('Build & Test') {
        sh './gradlew clean build'
    }
    stage('Sonar') {
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Run') {
        env.STAGE = "Run"
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Test') {
        sh 'env STAGE = "Test"'
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Nexus') {
        env.STAGE = "Nexus"
        println "Stage: ${env.STAGE_NAME}"
    }
}

return this;