package com.jfranceschini;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.Item;
import com.jfranceschini.library.Library;
import com.jfranceschini.library.LibraryMember;
import com.jfranceschini.library.MediaType;
import com.jfranceschini.library.Movie;
import com.jfranceschini.library.Music;
import com.jfranceschini.library.exception.LibraryItemAlreadyExistsException;
import com.jfranceschini.library.exception.LibraryItemDoesNotExistException;
import com.jfranceschini.library.exception.LibraryMemberDoesNotExistException;

/**
 * Library Driver
 * 
 * Interacts with the LibraryMember and Item classes to simulate a library.
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
		List<Item> libItems = new ArrayList<Item>();

		// // Create the library item
		Library library = new Library("Seattle Public Library");

		// // Create a bunch of members
		LibraryMember memberCharles = new LibraryMember("Charles", "Gardiner");
		LibraryMember memberJason = new LibraryMember("Jason", "Nichols");
		LibraryMember memberJill = new LibraryMember("Jill", "Wilson");
		LibraryMember memberRandy = new LibraryMember("Randy", "Savage");
		LibraryMember memberHulk = new LibraryMember("Hulk", "Hogan");

		// create some books
		Book javaBook = new Book(
			"Effective Java", 
			"Block", 
			"Addison-Wesley",
			new GregorianCalendar(2012, Calendar.JANUARY, 12).getTime(), 
			"ABCD-12345",
			MediaType.PHYSICAL);
		libItems.add(javaBook);

		Book scalaBook = new Book(
			"Scala for the impatient", 
			"Someone", 
			"Addison-Wesley",
			new GregorianCalendar(2014, Calendar.JANUARY, 12).getTime(), 
			"CDEF-12345",
			MediaType.ELECTRONIC);
		libItems.add(scalaBook);

		Book chefInfrastructureBook = new Book(
			"Chef Infrastructure", 
			"Matthias Marschalli", 
			"Packt", 
			new GregorianCalendar(2013, Calendar.JANUARY, 1).getTime(), 
			"CJEG-12937", 
			MediaType.PHYSICAL);
		libItems.add(chefInfrastructureBook);

		Book javaInANutShellBook = new Book(
			"Java In a Nutshell", 
			"David Flanigan", 
			"O'rielly",
			new GregorianCalendar(2011, Calendar.JULY, 15).getTime(), 
			"NJIE-88472",
			MediaType.ELECTRONIC);
		libItems.add(javaInANutShellBook);
		
		Book goodNightMoonBook = new Book(
			"Good Night Moon", 
			"Chazzyg", 
			"O'rielly",
			new GregorianCalendar(2011, Calendar.JULY, 15).getTime(), 
			"JSLE-00903",
			MediaType.PHYSICAL);
		libItems.add(goodNightMoonBook);

		// create some movies
		Movie birdManMovie = new Movie(
			"Birdman", 
			"Alejandro González", 
			"New Regency", 
			new GregorianCalendar(2014, Calendar.NOVEMBER, 14).getTime(), 
			MediaType.PHYSICAL);
		libItems.add(birdManMovie);

		Movie preMovie = new Movie(
			"Pre", 
			"Steve Buschemi", 
			"Lions Gate", 
			new GregorianCalendar(1990, Calendar.AUGUST, 12).getTime(), 
			MediaType.ELECTRONIC);
		libItems.add(preMovie);

		// create some music
		Music slantedAndEnchanted = new Music(
			"Slanted and Enchanged", 
			"Pavement", 
			"matador", 
			new GregorianCalendar(1992, Calendar.SEPTEMBER, 22).getTime(), 
			MediaType.ELECTRONIC);
		Music vanHalen = new Music(
			"1984", 
			"Van Halen", 
			"Columbia", 
			new GregorianCalendar(1983, Calendar.SEPTEMBER, 22).getTime(), 
			MediaType.PHYSICAL);

		libItems.add(vanHalen);
		libItems.add(vanHalen);

		// Lets add all the items to the library

		for (Item libItem : libItems) {
			try {
				library.addItem(libItem);
			} catch (LibraryItemAlreadyExistsException liae) {
				System.out.println("Duplicate item avoided.");
				liae.printStackTrace();
			}
		}

		try {
			library.addItem(preMovie);
		} catch (LibraryItemAlreadyExistsException liae) {
			System.out.println("Unable to add pre movie");
			liae.printStackTrace();
		}

		// Library is loaded with all items
		// lets check some things out

		try {
			library.checkoutItem(memberCharles, javaBook.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		}

		library.addLibraryMember(memberCharles);

		try {
			library.checkoutItem(memberCharles, javaBook.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		} finally {
			System.out.println("checked out!");
		}

		try {
			library.returnItem(memberCharles, slantedAndEnchanted.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		}

		try {
			library.addItem(slantedAndEnchanted);
		} catch (LibraryItemAlreadyExistsException e1) {
			System.out.println("Throwing library item already exists exception.");
			e1.printStackTrace();
		}

		try {
			library.returnItem(memberCharles, slantedAndEnchanted.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		} finally {
			System.out.println("Checked out.");
		}
	}
}
