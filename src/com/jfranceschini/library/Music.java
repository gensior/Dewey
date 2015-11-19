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
public class Music extends Item {
	/** A String of the artist performing the song */
	private String artist;

	/**
	 * Preferred constructor
	 * 
	 * @param title a String of the title of the song
	 * @param artist a String of the musician who performs the song
	 * @param publisher a String of the publisher of the song
	 * @param publishedDate a Date of the publish date
	 * @param mediaType a MediaType of the type of media the song is in
	 */
	public Music(
			String title, 
			String artist, 
			String publisher, 
			Date publishedDate, 
			MediaType mediaType) {
		super(title, publisher, publishedDate, mediaType);
		this.artist = artist;
		// TODO Auto-generated constructor stub
	}
	
	// Getters/Setters
	public String getArtist() {
		return this.artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	/**
	 * Determines checkout length based on media type
	 */
	public int determineCheckOutLength() {
		switch(this.mediaType) {
		case ELECTRONIC:
			return 30;
		case PHYSICAL:
			return 15;
		default:
			return 10;
		}
	}
	
	@Override
	/**
	 * Custom string representation of the class
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("MUSIC: " + this.title + " by " + this.artist + "\n");
		stringBuilder.append("-- media type: " + this.mediaType.getType() + "\n");
		if (this.checkedOut) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			stringBuilder.append("-- due on " + sdf.format(this.dueDate));
		} else {
			stringBuilder.append("-- not checked out");
		}
		return stringBuilder.toString();
	}
	
}
