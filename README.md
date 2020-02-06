To run tests from terminal:

mvn clean verify -q

clean - will delete target folder.
In target folder, you will find reports, compiled classes and project jar file.

verify - goal from maven lifecycle. Triggers cucumber runner class and then generates
report

-q - quite, to reduce output from maven in console.