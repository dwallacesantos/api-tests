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
    ENV=QA gradle clean test -i
### Running gradle wrapper
    ENV=QA ./gradlew clean test --i 

## Environments
* QA
* DEV
