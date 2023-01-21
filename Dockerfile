FROM openjdk:11

ARG environment=QA

ENV ENV=$environment

RUN mkdir -p /tests

COPY . /tests

WORKDIR /tests

CMD ["./gradlew", "clean", "test", "--i"]