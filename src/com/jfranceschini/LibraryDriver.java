package com.jfranceschini;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.Library;
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
	 * @param args
	 *            String array from the command line.
	 */
	public static void main(String[] args) {
		// Create the Library

		Library library = new Library("Seattle Public Library");

		// Create a few members

		LibraryMember memberCharles = new LibraryMember("Charles", "Gardiner");

		LibraryMember memberJason = new LibraryMember("Jason", "Nichols");

		LibraryMember memberJill = new LibraryMember("Jill", "Wilson");

		LibraryMember memberRandy = new LibraryMember("Rany", "James");

		// create some books

		// if your books have a different constructor, create the same objects
		// using your constructor

		Book effectiveJavaBook = new Book("Effective Java", "Block", "Addison-Wesley", 2012, 0, 12, "ABCD-12345");

		Book scalaBook = new Book("Scala for the impatient", "Someone", "Addison-Wesley", 2014, 0, 12, "XDEF-12339");

		Book chefInfrastructureBook = new Book("Chef Infrastructure", "Matthias Marschalli", "Packt", 2013, 0, 1, "HHDC-212543");

		Book javaInANutShellBook = new Book("Java In a Nutshell", "David Flanigan", "O'rielly", 2011, 6, 15, "LMNO-23233");

		Book neverInLibrary = new Book("Not a real book", "??", "board book", 2011, 6, 15, "XYZ3-3203");

		// add the books to the library

		library.addBook(effectiveJavaBook);

		library.addBook(scalaBook);

		library.addBook(chefInfrastructureBook);

		library.addBook(javaInANutShellBook);

		// lets check the library

		System.out.println(library.toString() + "\n");

		library.checkoutBook(memberCharles, effectiveJavaBook.getSbnNumber());

		System.out.println(library.toString() + "\n");

		// checkout a book that does not exist

		library.checkoutBook(memberCharles, neverInLibrary.getSbnNumber());

		// return a book that does not exist

		library.returnBook(memberCharles, neverInLibrary.getSbnNumber());

		// check out the same book twice

		library.checkoutBook(memberCharles, effectiveJavaBook.getSbnNumber());

		library.checkoutBook(memberRandy, effectiveJavaBook.getSbnNumber());

		System.out.println(library.toString() + "\n");

		library.returnBook(memberCharles, effectiveJavaBook.getSbnNumber());

		System.out.println(library.toString());

		library.checkoutBook(memberRandy, javaInANutShellBook.getSbnNumber());

		library.checkoutBook(memberJill, chefInfrastructureBook.getSbnNumber());

		library.checkoutBook(memberJason, scalaBook.getSbnNumber());

		System.out.println(library.toString() + "\n");

		library.returnBook(memberRandy, javaInANutShellBook.getSbnNumber());

		library.returnBook(memberJill, chefInfrastructureBook.getSbnNumber());

		library.returnBook(memberJason, scalaBook.getSbnNumber());

		library.checkoutBook(memberCharles, javaInANutShellBook.getSbnNumber());

		library.checkoutBook(memberCharles, chefInfrastructureBook.getSbnNumber());

		library.checkoutBook(memberCharles, scalaBook.getSbnNumber());

		library.checkoutBook(memberCharles, effectiveJavaBook.getSbnNumber());

		System.out.println(library.toString());
	}
}
