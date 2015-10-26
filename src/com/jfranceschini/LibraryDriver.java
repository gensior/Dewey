package com.jfranceschini;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.LibraryMember;

/**
 * Library Driver
 * 
 * Interacts with the LibraryMember and Book classes to simulate a library.
 * 
 * @author Jesse Franceschini
 *
 */
public class LibraryDriver {
	/**
	 * Just the main method to be run in the console
	 * 
	 * @param args String array from the command line.
	 */
	public static void main(String[] args) {
		// Instantiate some books
		// Green Eggs and Ham
		Book book1 = new Book("Green Eggs and Ham", 
				"Dr. Seuss", 
				"Scholastic", 
				1889,
				1,
				10);
		System.out.println(book1);
		// Hello World
		Book book2 = new Book("Hello World",
				"",
				"",
				1999,
				11,
				31);
		System.out.println(book2);
		// How to Serve Man
		Book book3 = new Book("How to Serve Man",
				"Kodos",
				"Intergalactic Press",
				1994);
		System.out.println(book3);
		// Stuff and Things (tests out no publish date upon instantiation)
		Book book4 = new Book("Stuff and Things",
				"Mr. Guy",
				"Book Publishers");
		System.out.println(book4);
		// Instantiate five LibraryMembers
		LibraryMember member1 = new LibraryMember("Jesse", "Franceschini");
		LibraryMember member2 = new LibraryMember("Homer", "Simpson");
		LibraryMember member3 = new LibraryMember("Lisa", "Simpson");
		LibraryMember member4 = new LibraryMember("Marge", "Simpson");
		LibraryMember member5 = new LibraryMember("Bart", "Simpson");
		member1.checkOutBook(book1);
		// Attempts to check out more than one book
		member1.checkOutBook(book2);
		member2.checkOutBook(book2);
		member3.checkOutBook(book3);
		member4.checkOutBook(book4);
		// Attempts to check out a book that's already been checked out
		member5.checkOutBook(book1);
	}
}
