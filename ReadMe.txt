Assignment 02 - Jesse Franceschini
==================================

Main Assignment:
================

To run the assignment, unzip the directory, cd into it, and 
enter the following into the command line:

javac -cp ./src src/com/jfranceschini/LibraryDriver.java

Then:

java -cp ./src com/jfranceschini/LibraryDriver

Design Decisions:
=================
Enforcement of checkout rules occurs at the Library class
level, rather than the LibraryMember or Book class levels.
I did this because it seemed like a natural place to put
the responsibility of handling checkout validation, the
Library is the object that knows the most about the
situation to handle whether all conditions are met.


Why Set or List?
================

In this assignment, I chose to use a Set to hold the books
that a LibraryMember currently has checked out. There was
really only one reason Set won out over List, and that was
because Set gracefully allows only one object of equal value
at a time to exist in a Set, whereas a Book added to a List 
must be checked by hand to ensure duplication doesn't happen.