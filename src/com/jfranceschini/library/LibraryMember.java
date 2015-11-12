package com.jfranceschini.library;

import java.util.HashSet;
import java.util.Set;

/**
 * Library Member
 * @author Jesse Franceschini
 *
 */
public class LibraryMember {
	/** First name of library member */
	private String firstName;
	/** Last name of library member */
	private String lastName;
	/** A set of books that the library member has currently checked out */
	private Set<Book> checkedOutBooks = new HashSet<Book>();
	
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
		book.setCheckedOut(checkedOutBooks.add(book));
	}
	
	/**
	 * returnBook
	 * 
	 * Removes a book from the checkedOutBooks set and sets the book's checkedOut boolean to false.
	 * @param book a Book object to return
	 * @return a boolean of whether removing the book from the checkedOutBooks set was successful
	 */
	public boolean returnBook(Book book) {
		book.setCheckedOut(false);
		return checkedOutBooks.remove(book);
	}
	// Getters / Setters
	// First Name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// Last Name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// Checked Out Books
	public Set<Book> getCheckedOutBooks() {
		return this.checkedOutBooks;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.firstName + " " + this.lastName);
		stringBuilder.append(" has currently checked out: \n");
		if (this.checkedOutBooks.isEmpty()) {
			stringBuilder.append("no books");
		} else {
			for (Book book : this.checkedOutBooks) {
				stringBuilder.append(book.toString() + "\n");
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * HashCode only uses firstName and lastName to generate a hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	/**
	 * Equality is based on the firstName and lastName, not the checkedOutBook set
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMember other = (LibraryMember) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
