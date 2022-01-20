# Getting Started
### Build Code
* ./gradlew clean build

### Run Jar
* Local:      ./gradlew bootRun 
* Pipeline:   nohup bash gradlew bootRun &

### Testing Application
* curl -X GET 'http://localhost:8082/rest/mscovid/test?msg=testing'
