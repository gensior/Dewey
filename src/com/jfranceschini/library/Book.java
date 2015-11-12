package com.jfranceschini.library;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Book
 * @author Jesse Franceschini
 *
 */
public class Book {
	/** The book's title */
	private String title;
	/** The book's author */
	private String author;
	/** When the book was published */
	private Date publishedDate;
	/** Who published the book */
	private String publisher;
	/** Boolean to say if the book is checked out */
	private boolean checkedOut;
	/** LibraryMember object that checked out the book */
	private LibraryMember checkerOuter;
	/** String that represents the book's sbnNumber */
	private String sbnNumber;
	
	/**
	 * Creates a Book object.
	 * 
	 * This is the preferred method for creating a Book object.
	 * Overloading the constructor allows Book objects to be created 
	 * when the published date is not fully known. If the year is missing
	 * the current year is used. If the month is missing, January is used.
	 * If the day is missing, the first of the month is used.
	 * 
	 * Furthermore, if the author is blank, then the default value of 
	 * 'Anonymous' is used.
	 * 
	 * New books are never checked out by default.
	 * 
	 * @param title string for title
	 * @param author string for author
	 * @param publisher string for publisher
	 * @param year integer for publish date year
	 * @param month integer for publish date month
	 * @param day integer for publish date year
	 * @param sbnNumber String for the SBN number
	 */
	public Book(String title, String author, String publisher, int year, int month, int day, String sbnNumber) {
		// Set the title from the arguments
		this.title = title;
		// If the author was passed in
		if (author != null && author.length() > 0) {
			// ...set it from the value of the argument
			this.author = author;
		} else {
			// ...otherwise default to 'Anonymous'
			this.author = "Anonymous";
		}
		// Set the publisher from the arguments
		this.publisher = publisher;
		// Check if the date was passed in
		if (year == 0){
			// If not, default to the current date time
			this.publishedDate = new GregorianCalendar().getTime();
		} else {
			// If so, use the year, month, and day arguments to set the published date
			this.publishedDate = new GregorianCalendar(year, month, day).getTime();
		}
		// By default, a new book is not checked out
		this.checkedOut = false;
		this.sbnNumber = sbnNumber;
	}
	
	/**
	 * Prints whether the book is checked out or not.
	 */
	public void printStatus() {
		if (this.checkedOut) {
			System.out.println("\"" + title + "\" is checked out.");
		} else {
			System.out.println("\"" + title + "\" is not checked out.");
		}
	}
	
	// Getters / Setters
	// Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// Author
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	// Published Date
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(int year, int month, int day) {
		this.publishedDate = new GregorianCalendar(year, month, day).getTime();
	}
	// Publisher
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	// Checked Out
	public boolean isCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	// Library Member
	public LibraryMember getCheckerOuter() {
		return checkerOuter;
	}
	public void setCheckerOuter(LibraryMember checkerOuter) {
		this.checkerOuter = checkerOuter;
	}
	// SBN Number
	public String getSbnNumber() {
		return this.sbnNumber;
	}
	public void setSbnNumber(String sbnNumber) {
		this.sbnNumber = sbnNumber;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		return title + " by " + author;
	}

	/**
	 * hashCode only uses the sbnNumber attribute to generate a hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sbnNumber == null) ? 0 : sbnNumber.hashCode());
		return result;
	}

	/**
	 * Equality only depends on the sbnNumber attribute
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (sbnNumber == null) {
			if (other.sbnNumber != null)
				return false;
		} else if (!sbnNumber.equals(other.sbnNumber))
			return false;
		return true;
	}
	
	
}
