package com.jfranceschini.library;

/**
 * Library Member
 * @author Jesse Franceschini
 *
 */
public class LibraryMember {
	/**
	 * First name of library member
	 */
	private String firstName;
	/**
	 * Last name of library member
	 */
	private String lastName;
	/**
	 * Book that the library member has checked out
	 */
	private Book bookCheckedOut;
	
	/**
	 * Constructor for the LibraryMember
	 * 
	 * By default, LibraryMembers cannot have a book checked out when they are created.
	 * 
	 * @param firstName String of the first name
	 * @param lastName String of the last name
	 */
	public LibraryMember(String firstName, String lastName) {
		// Sets the first name of the library member
		this.firstName = firstName;
		// Sets the last name of the library member
		this.lastName = lastName;
		// By default, no book can be checked out on instantiation
		this.bookCheckedOut = null;
	}
	
	/**
	 * Checks out a book for the LibraryMember
	 * 
	 * Books can only be checked out if they aren't already checked out.
	 * LibraryMembers can only check out one book at a time.
	 * 
	 * @param book the Book object to be checked out
	 */
	public void checkOutBook(Book book) {
		// If the book is not checked out and the LibraryMember has no book checked out
		if (bookCheckedOut == null && !book.isCheckedOut()) {
			// Set the book in the LibraryMember
			setBookCheckedOut(book);
			// Set the book's checked out status
			book.setCheckedOut(true);
			// Register the LibraryMember with the book so it knows who checked it out
			book.setCheckerOuter(this);
			System.out.println(firstName + " " + lastName + " checked out \"" + book.getTitle() + "\".");
		} else {
			// Otherwise the book can't be checked out
			System.out.println(firstName + " " + lastName + " failed to check out \"" + book.getTitle() + "\".");
			if (bookCheckedOut != null) {
				// Because the LibraryMember already has a book checked out
				System.out.println(firstName + " " + lastName + " must return \"" + bookCheckedOut.getTitle() + "\" first.");
			}
			if (book.isCheckedOut()) {
				// Or because the book's been checked out by another LibraryMember
				System.out.println(book.getCheckerOuter().getFirstName() + " " +
					book.getCheckerOuter().getLastName() + " has already checked out \"" +
					book.getTitle() + "\".");
			}
		}
	}

	/**
	 * Gets the first name of the LibraryMember
	 * 
	 * @return a String of the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the LibraryMember
	 * 
	 * @param firstName a String of the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name of the LibraryMember
	 * 
	 * @return a String of the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the LibraryMember's last name
	 * 
	 * @param lastName a String of the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the checked out book
	 * 
	 * @return a Book that the LibraryMember has checked out
	 */
	public Book getBookCheckedOut() {
		return bookCheckedOut;
	}

	/**
	 * Sets the checked out book
	 * 
	 * @param bookCheckedOut a Book to be checked out
	 */
	public void setBookCheckedOut(Book bookCheckedOut) {
		this.bookCheckedOut = bookCheckedOut;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		String output = "*******LibraryMember*******" +
				"\nName: " + firstName + " " + lastName;
		if (bookCheckedOut != null) {
			output += "\nBook: " + bookCheckedOut.toString();
		} else {
			output += "\nBook: none";
		}
		return output;
	}
	
	
}
