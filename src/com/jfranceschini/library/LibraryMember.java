package com.jfranceschini.library;

public class LibraryMember {
	private String first_name;
	private String last_name;
	private Book book_checked_out;
	
	public LibraryMember(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.book_checked_out = null;
	}
	
	public void checkOutBook(Book book) {
		if (!book.isChecked_out()) {
			setBook_checked_out(book);
			book.setChecked_out(true);
			System.out.println("User checked out book.");
		} else {
			System.out.println("User failed to check out book.");
		}
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Book getBook_checked_out() {
		return book_checked_out;
	}

	public void setBook_checked_out(Book book_checked_out) {
		this.book_checked_out = book_checked_out;
	}
	
	
}
