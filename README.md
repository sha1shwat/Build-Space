# Build-Space

## Description
This is code for the java based implementation of build space problem statement described below.

### Requirements

The project is built using Java 1.8. It uses Maven as the build system.

1. Java - 1.8.x
2. Maven - 3.x.x

### Building the application using maven

You can build and package the application in the form of a jar file using maven -

```
cd application
mvn clean package
```

The above command will produce a standalone jar file named ` make-space-1.0.jar` in the `/Make-Space/target` directory.

### Running Tests

The `mvn package` command runs all the unit tests and also packages the application in the form of a jar file. If you just want to run the tests without packaging it, then you can use `mvn test` command.

```
cd application
mvn test
```

### Running the application

You can run the jar file created by the `mvn package` command like so -

```
java -jar target/application.jar
```

### Running the functional tests

The application can take input commands from a file. You can pass multiple commands separated by a newline in the file like so -

```
java -jar target/goparking.jar file_input.txt
```

## Problem Statement
Build Space Ltd. is a startup offering a co-working space to individuals, freelancers and startups. They provide a common workspace where anyone can come and work. Along with it, they have dedicated meeting rooms that their customers can book for private discussions.

They are looking for a scheduling system to effectively schedule meetings. Can you build such a system for Build Space Ltd.?

Build Space Ltd. currently has 3 meeting rooms with varying capacity

- L-Cave with person capacity 4.
- M-Tower with person capacity 8.
- N-Mansion with person capacity 10.

#### Person Capacity 
  - Maximum number of people the meeting room can accommodate.
#### Buffer Time 
  - Buffer time is the time used to clean up the meeting room. It happens at fixed times from 09:00 - 09:15, 13:15 - 13:45 and 18:45 - 19:00. During this time, no meeting rooms will be available to book.
