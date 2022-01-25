def call() {
    stage('Build & Test') {
        environment {
            STAGE = ${env.STAGE_NAME}
        }
        sh './gradlew clean build'
    }
    stage('Sonar') {
        environment {
            STAGE = ${env.STAGE_NAME}
        }
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Run') {
        environment {
            STAGE = ${env.STAGE_NAME}
        }
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Test') {
        environment {
            STAGE = ${env.STAGE_NAME}
        }
        println "Stage: ${env.STAGE_NAME}"
    }
    stage('Nexus') {
        environment {
            STAGE = ${env.STAGE_NAME}
        }
        println "Stage: ${env.STAGE_NAME}"
    }
}

return this;