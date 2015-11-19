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
This time enforcement of checkout rules occurs at both 
the Library class level and the LibraryMember class levels.

Checkout Enforcement:
---------------------
The Library class is responsible for determining if the
member checking out an item has not reached their checkout
limit yet and if the item being checked out hasn't already
been checked out by someone else.

Return Enforcement:
-------------------
The Library class is responsible for determining if the
item being returned exists in the library's catalogue and
if the member returning the item exists in the library's
member list.

The LibraryMember class is responsible for determining if
the item being returned was checked out by the member
returning the item.

Determining Return Date:
------------------------
Calculating the return date is done via a method in the
Item abstract class. This method, however is not abstract.
I does depend on an abstract method that determines the
due date offset. Each Item subclass is responsible for
implementing this method and using it to further calculate
the required return dates of items of certain media types.

Media Types:
------------
Media types is a class enumeration. This was pretty
straightforward.