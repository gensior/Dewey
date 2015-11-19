package com.jfranceschini;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.Library;
import com.jfranceschini.library.LibraryMember;
import com.jfranceschini.library.MediaType;
import com.jfranceschini.library.Movie;
import com.jfranceschini.library.Music;

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
		// Create the library
		Library library = new Library("Seattle Public Library");

		// Create members
		LibraryMember memberCharles = new LibraryMember("Charles", "Gardiner");
		LibraryMember memberJason = new LibraryMember("Jason", "Nichols");
		LibraryMember memberJill = new LibraryMember("Jill", "Wilson");

		// create some library items
		Book electronicBook = new Book("Effective Java", "Block", "Addison-Wesley",
		    new GregorianCalendar(2012, Calendar.JANUARY, 12).getTime(), "ABCD-12345", MediaType.ELECTRONIC);

		Book physicalBook = new Book("Scala for the impatient", "Someone", "Addison-Wesley",
		    new GregorianCalendar(2014, Calendar.JANUARY, 12).getTime(), "XDEF-12339", MediaType.PHYSICAL);

		Book unknownBook = new Book("Chef Infrastructure", "Matthias Marschalli", "Packt",
		    new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), "HHDC-212543", MediaType.UNKNOWN);

		Movie physicalMovie = new Movie("Independence Day", "Michael Bay", "Sony", 
			new GregorianCalendar(2011, Calendar.JANUARY, 1).getTime(), MediaType.PHYSICAL);
		
		Movie electronicMovie = new Movie("Jurassic Park", "Stephen Spielberg", "Universal", 
				new GregorianCalendar(1994, Calendar.JANUARY, 1).getTime(), MediaType.ELECTRONIC);

		Movie unknownMovie = new Movie("Star Wars", "George Lucas", "Fox",
				new GregorianCalendar(1978, Calendar.JANUARY, 1).getTime(), MediaType.UNKNOWN);
		
		Music electronicMusic = new Music("Computer World", "Kraftwerk", "Virgin",
				new GregorianCalendar(1969, Calendar.JANUARY, 1).getTime(), MediaType.ELECTRONIC);
		
		Music physicalMusic = new Music("Nevermind", "Nirvana", "Sub Pop",
				new GregorianCalendar(1991, Calendar.JANUARY, 1).getTime(), MediaType.PHYSICAL);
		
		Music unknownMusic = new Music("Random Access Memories", "Daft Punk", "Something",
				new GregorianCalendar(2014, Calendar.JANUARY, 1).getTime(), MediaType.UNKNOWN);
		
		Movie notAddedMovie = new Movie("Toy Story", "Pixar", "Disney",
				new GregorianCalendar(1999, Calendar.JANUARY, 1).getTime(), MediaType.PHYSICAL);
		
		// Add items to the library
		library.addItem(electronicBook);
		library.addItem(physicalBook);
		library.addItem(unknownBook);
		library.addItem(electronicMovie);
		library.addItem(physicalMovie);
		library.addItem(unknownMovie);
		library.addItem(electronicMusic);
		library.addItem(physicalMusic);
		library.addItem(unknownMusic);


		// let's check the library
		System.out.println(library.toString() + "\n");
		// Check out an item
		System.out.println("*** charles checks out an e-book ***");
		library.checkoutItem(memberCharles, electronicBook.getId());
		// Try checking out an item that's already checked out
		System.out.println("*** checking out item that's already checked out ***");
		library.checkoutItem(memberJill, electronicBook.getId());
		// Return an Item
		System.out.println("*** charles returns an e-book ***");
		library.returnItem(memberCharles, electronicBook.getId());
		// A returned item can now be checked out
		System.out.println("*** jill checks out an e-book ***");
		library.checkoutItem(memberJill, electronicBook.getId());
		// checkout an item that does not exist in the library
		System.out.println("*** checking out item that's not in library ***");
		library.checkoutItem(memberJason, notAddedMovie.getId());
		// return an item that was not checked out
		System.out.println("*** returning an item that wasn't checked out ***");
		library.returnItem(memberJason, notAddedMovie.getId());
		// check out an item
		System.out.println("*** jason checks out physical music ***");
		library.checkoutItem(memberJason, physicalMusic.getId());
		// return item from wrong person
		System.out.println("*** wrong person returning an item ***");
		library.returnItem(memberJill, physicalMusic.getId());
		// try to check out more than 3 items
		System.out.println("*** try to check out more than 3 items ***");
		library.checkoutItem(memberJill, physicalMovie.getId());
		library.checkoutItem(memberJill, unknownMovie.getId());
		library.checkoutItem(memberJill, unknownMusic.getId());

		// let's check the library again
		System.out.println(library.toString());
	}
}
