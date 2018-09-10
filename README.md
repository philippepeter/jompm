# Java Offline Multiprocess Manager

Java library to manage some external processes even when the master Java process is offline.

## Concept
Use the ProcessBuilder to launch tasks, listen to a status for progression and get the pid to allow to retreive 
the state and kill the process even after a relaunch. 
The status listening first implementation is by using a `status.data` file with just an integer for the percentage 
of progress. 100 when it's done.
Future implementations could use a web service or other technics.

## Test project
A test project is in the _`jompm-test-exec`_ folder to create an executable jar for testing purpose.
A copy of the compiled jar file is used in the JUnit tests resources folder.
