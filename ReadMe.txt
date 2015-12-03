Assignment 02 - Jesse Franceschini
==================================

Main Assignment:
================

To run the assignment, unzip the directory, cd into it, and 
enter the following into the command line:

javac -cp ./src src/com/jfranceschini/LibraryDriver.java

Then:

java -cp ./src com/jfranceschini/LibraryDriver

Part3:
=================

Swallowing Exceptions:
----------------------
"Swallowing" exceptions means having catch statements that
do nothing useful with the caught exceptions. In the worst
case, the catch statement is empty, otherwise swallowed
exceptions may also be where exceptions are caught, handled
poorly, and not passed along to other parts of the program.

This is bad practice because it obstructs the cause of
exceptions and makes it harder to correct errors in programs.

RuntimeException vs Exception:
------------------------------
RuntimeExceptions are unchecked exceptions, meaning that when
the program is compiled, no verification is performed to ensure
that these exceptions are handled.  Exceptions are checked
exceptions, which is to say that the compiler verifies that
they are handled when the program is compiled. In other words,
checked exceptions must have try/catch or throws statements
where ever they're found, whereas unchecked exceptions are thrown
at runtime and are therefore less predictable, so the compiler
doesn't perform any verification that try/catch or throws
statements are in place to handle them.