Assignment 02 - Jesse Franceschini
==================================

Main Assignment:

To run the assignment, unzip the directory, cd into it, and 
enter the following into the command line:

javac -cp ./src src/com/jfranceschini/LibraryDriver.java

Then:

java -cp ./src com/jfranceschini/LibraryDriver

BONUS 1:

	The checkOutBook method in the LibraryMember class contains
extra logic to explain the nature of the checkout failure.

If the LibraryMember already has a book in their possession, a
message explaining that the already checked out book must be
returned is printed in the console.

If the Book is checked out by a different member, a message
explaining that a LibraryMember must return their book first is
printed to the console. Thanks to the Book's getCheckerOuter
method, information about the LibraryMember that checked out the
book can be used for the message.

BONUS 2:

	See the file named UML.png for the UML diagram for this bonus.
I was unsure of how to show that the Book class makes a reference
to the LibraryMember class and vice versa, so I placed an
un-arrowed line between both classes since the association goes
both ways.