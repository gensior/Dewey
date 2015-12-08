package com.jfranceschini.library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Music
 * 
 * This extends the Item abstract class and implements its own logic for determining checkout length
 * @author Jesse Franceschini
 *
 */
public class Movie extends LibraryItem {
	/** A String of the director */
	private String director;
	
	/**
	 * Preferred constructor
	 * 
	 * @param title a String of the title of the movie
	 * @param director a String of the director of the movie
	 * @param publisher a String of the publisher of the movie
	 * @param publishedDate a Date of when the movie was published
	 * @param mediaType a MediaType of the type of media the movie is in
	 */
	public Movie(
			String title, 
			String director, 
			String publisher, 
			Date publishedDate,
			MediaType mediaType) {
		super(title, publisher, publishedDate, mediaType);
		this.director = director;
	}

	// Getters/Setters
	public String getDirector() {
		return this.director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	
	@Override
	/**
	 * Custom string representation
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("MOVIE: " + this.title + " by " + this.director + "\n");
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
	 * Determines the checkout length based on media type
	 */
	public int determineCheckOutLength() {
		switch(this.mediaType) {
		case ELECTRONIC:
			return 45;
		case PHYSICAL:
			return 25;
		default:
			return 10;
		}
	}

}
