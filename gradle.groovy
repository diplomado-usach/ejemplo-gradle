def call() {
    stage('Build & Test') {
        STAGE = env.STAGE_NAME
        sh 'env'
//        sh './gradlew clean build'
    }
    stage('Sonar') {
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Run') {
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Test') {
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Nexus') {
        println "Stage: ${env.STAGE_NAME}"
    }
}

return this;