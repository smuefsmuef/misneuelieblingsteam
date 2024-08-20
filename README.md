# ProcessingTemplate


## Setup

Processing4 `core.jar` is included in the repo. But you have to install it in your local maven-repository.

Enter this command in IntelliJ IDEA's Terminal Window (tested on Mac):
```shell
mvn install:install-file -Dfile=src/main/resources/lib/core.jar -DgroupId=org.processing -DartifactId=core -Dversion=4.0 -Dpackaging=jar -DgeneratePom=true
```

if this does not work, try (tested on Windows):
```shell
mvn install:install-file -Dfile="src/main/resources/lib/core.jar" -DgroupId="org.processing" -DartifactId="core" -Dversion="4.0" -Dpackaging="jar"
```

After this step the example applications are compiling, and you can start them, either locally or on a Raspberry Pi.

## Running the App

Run MainClass as any other Java Application to start any Processing project defined there.

Use packages to define different apps/projects in this repo.

Use the Run Configurations "Run on Pi", "Local Run", "Debug on Pi" and "Attach to Pi Debugger" to run the application via Maven, either locally on your laptop or remote on a Raspberry Pi.


