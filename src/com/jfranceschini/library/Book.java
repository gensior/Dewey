package com.jfranceschini.library;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Book
 * @author Jesse Franceschini
 *
 */
public class Book {
	/**
	 * The book's title
	 */
	private String title;
	/**
	 * The book's author
	 */
	private String author;
	/**
	 * When the book was published
	 */
	private Date publishedDate;
	/**
	 * Who published the book
	 */
	private String publisher;
	/**
	 * Boolean to say if the book is checked out
	 */
	private boolean checkedOut;
	/**
	 * LibraryMember object that checked out the book
	 */
	private LibraryMember checkerOuter;
	
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
	 */
	public Book(String title, String author, String publisher, int year, int month, int day) {
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
	}
	
	/**
	 * Creates a Book object and uses published date defaults.
	 * 
	 * @param title string for book title
	 * @param author string for book author
	 * @param publisher string for book publisher
	 */
	public Book(String title, String author, String publisher) {
		this(title, author, publisher, 0, 0, 1);
	}
	
	/**
	 * Creates a Book object when only the published date year is known.
	 * 
	 * @param title string for book title
	 * @param author string for book author
	 * @param publisher string for book publisher
	 * @param year integer for published date year
	 */
	public Book(String title, String author, String publisher, int year) {
		this(title, author, publisher, year, 0, 1);
	}
	
	/**
	 * Creates a Book object when the published date year and month are known.
	 * 
	 * @param title string for book title
	 * @param author string for book author
	 * @param publisher string for book publisher
	 * @param year integer for published date year
	 * @param month integer for published date month
	 */
	public Book(String title, String author, String publisher, int year, int month) {
		this(title, author, publisher, year, month, 1);
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
	
	/**
	 * Gets the book's title
	 * 
	 * @return a String of the book's title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the book's title
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the book's author
	 * 
	 * @return a String of the book's author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the book's author
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the book's published date
	 * 
	 * @return a Date of the book's published date
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	/**
	 * Sets the book's published date
	 * 
	 * Uses the GregorianCalendar class to allow input to be in integers.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public void setPublishedDate(int year, int month, int day) {
		this.publishedDate = new GregorianCalendar(year, month, day).getTime();
	}
	
	/**
	 * Gets the book's publisher
	 * 
	 * @return a String of the book's publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Sets the book's publisher
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Checks if the book is checked out or not
	 * 
	 * @return a boolean of whether the book is checked out or not
	 */
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	/**
	 * Sets the book's checkedOut value
	 * 
	 * @param checkedOut
	 */
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	/**
	 * Gets the LibraryMember object that checked out the book
	 * 
	 * @return a LibraryMember object
	 */
	public LibraryMember getCheckerOuter() {
		return checkerOuter;
	}

	/**
	 * Sets the LibraryMember that is checking out the book
	 * 
	 * @param checkerOuter
	 */
	public void setCheckerOuter(LibraryMember checkerOuter) {
		this.checkerOuter = checkerOuter;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		return "*******Book*******" +
				"\nTitle: " + title + 
				"\nAuthor: " + author + 
				"\nPublished At: " + publishedDate + 
				"\nPublisher: " + publisher + 
				"\nChecked Out: " + checkedOut;
	}
}
