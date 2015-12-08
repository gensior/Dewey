package com.jfranceschini.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Book
 * @author Jesse Franceschini
 *
 */
public class Book extends LibraryItem {
	/** A String of the sbnNumber of the book */
	private String sbnNumber;
	/** A String of the author of the book */
	private String author;
	
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
	 * @param publishedDate a Date for when the book was published
	 * @param sbnNumber String for the SBN number
	 * @param mediaType a MediaType for the type of media the book is in
	 */
	public Book(
			String title, 
			String author, 
			String publisher, 
			Date publishedDate, 
			String sbnNumber, 
			MediaType mediaType) {
		super(title, publisher, publishedDate, mediaType);
		// If the author was passed in
		if (author != null && author.length() > 0) {
			// ...set it from the value of the argument
			this.author = author;
		} else {
			// ...otherwise default to 'Anonymous'
			this.author = "Anonymous";
		}
		this.sbnNumber = sbnNumber;
	}
	
	// Getters/Setters
	public String getSbnNumber() {
		return this.sbnNumber;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("BOOK: " + this.title + " by " + this.author + "\n");
		stringBuilder.append("-- media type: " + this.mediaType.getType() + "\n");
		if (this.checkedOut) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			stringBuilder.append("-- due on " + sdf.format(this.dueDate));
		} else {
			stringBuilder.append("-- not checked out");
		}
		return stringBuilder.toString();
	}
	
	@Override
	/**
	 * Determines checkout length based on media type
	 */
	public int determineCheckOutLength() {
		switch(this.mediaType) {
		case ELECTRONIC:
			return 50;
		case PHYSICAL:
			return 20;
		default:
			return 10;
		}
	}
	
	
}
