package com.jfranceschini.library;

public class LibraryMember {
	private String firstName;
	private String lastName;
	private Book bookCheckedOut;
	
	public LibraryMember(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookCheckedOut = null;
	}
	
	public void checkOutBook(Book book) {
		if (bookCheckedOut == null && !book.isCheckedOut()) {
			setBookCheckedOut(book);
			book.setCheckedOut(true);
			book.setCheckerOuter(this);
			System.out.println(firstName + " " + lastName + " checked out " + book.getTitle() + ".");
		} else {
			System.out.println(firstName + " " + lastName + " failed to check out " + book.getTitle() + ".");
			if (bookCheckedOut != null) {
				System.out.println(firstName + " " + lastName + " must return " + bookCheckedOut.getTitle() + " first.");
			}
			if (book.isCheckedOut()) {
				System.out.println(book.getCheckerOuter().getFirstName() + " " +
					book.getCheckerOuter().getLastName() + " has already checked out " +
					book.getTitle() + ".");
			}
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Book getBookCheckedOut() {
		return bookCheckedOut;
	}

	public void setBookCheckedOut(Book bookCheckedOut) {
		this.bookCheckedOut = bookCheckedOut;
	}

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
