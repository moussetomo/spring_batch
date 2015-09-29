# spring_batch

## How to run
1. Install MySQL server (my version is 5.6.20) to localhost.
2. Run SQL script located in DB folder to create a database and a user.
3. Make sure Java 7 and Maven 3 are installed.
4. Modify input file located in src/main/resources/scores.txt if you want, src/test/resources/scores-test.txt in case of test.
5. run `mvn test` to compile and test the program.
6. run `mvn package` to create runnable jar file.
7. run `java -jar target/springBatch-1-jar-with-dependencies.jar`.

## Note
This program reads input file from src/main/resources/scores.txt.
And it automatically creates table if not any, and writes data to it.
Test program drops and creates new table for each run.
