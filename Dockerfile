FROM openjdk
ADD target/kameleoon_test_task-0.0.1-SNAPSHOT.jar kameleoon_test_task-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kameleoon_test_task-0.0.1-SNAPSHOT.jar"]