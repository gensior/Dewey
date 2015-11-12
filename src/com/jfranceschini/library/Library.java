package com.jfranceschini.library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Library
 * @author Jesse Franceschini
 *
 */
public class Library {
	/** The name of the library */
	private String name;
	/** A map of books that the library has in its collection */
	private Map<String, Book> bookMap = new HashMap<String, Book>();
	/** A set of library member that belong to the library */
	private Set<LibraryMember> members = new HashSet<LibraryMember>();
	/** A constant to limit the number of books the library allows one user to check out */
	public final static int CHECKOUT_LIMIT = 3;
	
	/**
	 * Constructor for the Library class
	 * 
	 * @param name a String to represent the name of the library
	 */
	public Library(String name) {
		this.name = name;
	}
	
	/**
	 * addBook
	 * 
	 * Adds a book to the library's bookMap Map.
	 * @param book a Book object to add to the library
	 */
	public void addBook(Book book) {
		// If the bookMap doesn't already contain a book with the same SbnNumber
		if (!bookMap.containsKey(book.getSbnNumber())) {
			// Add the book to the bookMap
			bookMap.put(book.getSbnNumber(), book);
		} else {
			// Otherwise print out an error message
			System.out.println(book.getTitle() + " already exists in " + this.name + ".");
		}
	}
	
	/**
	 * checkOutBook
	 * 
	 * If the book isn't null, isn't already checked out, and the member checking out the book hasn't reached their checkout limit, then check the book out.
	 * @param member a LibraryMember trying to check out a book
	 * @param sbnNumber a String referencing a book object in the bookMap
	 */
	public void checkoutBook(LibraryMember member, String sbnNumber) {
		// Double membership already taken care of by set
		members.add(member);
		// Get the book object from the bookMap
		Book book = bookMap.get(sbnNumber);
		// Check if the book isn't null, isn't checked out, and if the member can still check out books
		if (book != null && !book.isCheckedOut() && member.getCheckedOutBooks().size() < CHECKOUT_LIMIT) {
			// Check out that book
			member.checkOutBook(book);
		} else {
			// Otherwise, print an error message
			System.out.println("Could not find book to check out. Or past your limit.");
		}
	}
	
	/**
	 * returnBook
	 * 
	 * Returns a book to the library if the book exists in the library's bookMap and the book exists in the member's book set.
	 * @param member a LibraryMember trying to return a book
	 * @param book a String representing the SbnNumber of the book to be returned
	 */
	public void returnBook(LibraryMember member, String book) {
		if (bookMap.containsKey(book)) {
			if (members.contains(member)) {
				Book booktoReturn = bookMap.get(book);
				member.returnBook(booktoReturn);
				booktoReturn.setCheckedOut(false);
			} else {
				System.out.println("Member not found in library.");
			}
		} else {
			System.out.println("This book is not checked out or does not exist.");
		}
	}
	
	/**
	 * Prints out the library's name, members, and what books they've checked out
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Library: " + this.name + "\n");
		stringBuilder.append("Library Books:\n");
		for (Book book : bookMap.values()) {
			stringBuilder.append("-- " + book.toString() + "\n");
		}
		stringBuilder.append("\nLibrary Members:\n");
		if (members.size() > 0) {
			for (LibraryMember member: members) {
				stringBuilder.append(member.toString() + "\n");
			}
		} else {
			stringBuilder.append("none\n");
		}
		return stringBuilder.toString();
	}
}
