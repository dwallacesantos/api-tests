# API tests

## Tools
* OpenJDK - 11
* REST-assured - 5.3.0
* Kotlin - 1.7.21
* Junit - 5

## Run
### Running docker
    docker build -t tests --build-arg environment=QA .
    docker run tests
### Running gradle
    ENV=QA gradle test -i --rerun-tasks 
### Running gradle wrapper
    ENV=QA ./gradlew test --i --rerun-tasks 

## Environments
* QA
* DEV
