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
		if (book_checked_out == null && !book.isChecked_out()) {
			setBook_checked_out(book);
			book.setChecked_out(true);
			book.setChecker_outer(this);
			System.out.println(first_name + " " + last_name + " checked out " + book.getTitle() + ".");
		} else {
			System.out.println(first_name + " " + last_name + " failed to check out " + book.getTitle() + ".");
			if (book_checked_out != null) {
				System.out.println(first_name + " " + last_name + " must return " + book_checked_out.getTitle() + " first.");
			}
			if (book.isChecked_out()) {
				System.out.println(book.getChecker_outer().getFirst_name() + " " +
					book.getChecker_outer().getLast_name() + " has already checked out " +
					book.getTitle() + ".");
			}
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

	@Override
	public String toString() {
		String output = "*******LibraryMember*******" +
				"\nName: " + first_name + " " + last_name;
		if (book_checked_out != null) {
			output += "\nBook: " + book_checked_out.toString();
		} else {
			output += "\nBook: none";
		}
		return output;
	}
	
	
}
