package com.jfranceschini;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.LibraryItem;
import com.jfranceschini.library.LibraryBranch;
import com.jfranceschini.library.LibraryMember;
import com.jfranceschini.library.LibraryMember.LibraryMemberBuilder;
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
		List<LibraryItem> libItems = new ArrayList<LibraryItem>();

		// // Create the library item
		LibraryBranch ballardLibrary = new LibraryBranch("Ballard Public Library");
		// LibraryBranch qaLibrary = new LibraryBranch("Queen Anne Library");

		// // Create a bunch of members
		LibraryMemberBuilder lmb = new LibraryMemberBuilder("Charles", "Gardiner")
			.withAddress("1234 Main St.")
			.withPhoneNumber("206-123-4567")
			.withSocialSecurityNumber("7")
			.withTitle("Mr.")
			.withGender("Male")
			.withMiddleName("Mancy");
		LibraryMember memberCharles = lmb.build();
		System.out.println(memberCharles);
//		LibraryMember memberJason = new LibraryMember("Jason", "Nichols");
//		LibraryMember memberJill = new LibraryMember("Jill", "Wilson");
//		LibraryMember memberRandy = new LibraryMember("Randy", "Savage");
//		LibraryMember memberHulk = new LibraryMember("Hulk", "Hogan");

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

		for (LibraryItem libItem : libItems) {
			try {
				ballardLibrary.addItem(libItem);
			} catch (LibraryItemAlreadyExistsException liae) {
				System.out.println("Duplicate item avoided.");
				liae.printStackTrace();
			}
		}

		try {
			ballardLibrary.addItem(preMovie);
		} catch (LibraryItemAlreadyExistsException liae) {
			System.out.println("Unable to add pre movie");
			liae.printStackTrace();
		}

		// Library is loaded with all items
		// lets check some things out

		try {
			ballardLibrary.checkoutItem(memberCharles, javaBook.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		}

		ballardLibrary.addLibraryMember(memberCharles);

		try {
			ballardLibrary.checkoutItem(memberCharles, javaBook.getId());
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
			ballardLibrary.returnItem(memberCharles, slantedAndEnchanted.getId());
		} catch (LibraryMemberDoesNotExistException e) {
			System.out.println("Throwing missing library member exception.");
			e.printStackTrace();
		} catch (LibraryItemDoesNotExistException e) {
			System.out.println("Throwing missing library item exception.");
			e.printStackTrace();
		}

		try {
			ballardLibrary.addItem(slantedAndEnchanted);
		} catch (LibraryItemAlreadyExistsException e1) {
			System.out.println("Throwing library item already exists exception.");
			e1.printStackTrace();
		}

		try {
			ballardLibrary.returnItem(memberCharles, slantedAndEnchanted.getId());
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
