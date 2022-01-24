def call(){
    stage('Compile'){
        sh './mvnw clean compile -e'
    }
    stage('Test'){
        sh './mvnw clean test -e'
    }
    stage('Jar'){
        sh './mvnw clean package -e'
    }
    stage('Run'){
        sh 'JENKINS_NODE_COOKIE=dontKillMe nohup bash mvnw spring-boot:run &'
    }
    stage('TestApp'){
        sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=testing'"
    }
}
return this;