package com.jfranceschini.library;

/**
 * MediaType
 * 
 * This is an enum class that enumerates the types of media
 * that are possible in the library application. Currently there
 * are three types, Electronic, Physical, Unknown.
 * 
 * @author Jesse Franceschini
 *
 */
public enum MediaType {
	/**
	 * This populates the enum with two selections, Work and Home
	 */
	ELECTRONIC ("E-media"), 
	PHYSICAL ("Physical Media"),
	UNKNOWN ("Unknown");
	
	/**
	 * the type is represented as a String
	 */
	private final String type;
	
	/**
	 * Private Constructor Method
	 * 
	 * @param type a String representing the type
	 */
	private MediaType(String type) {
		this.type = type;
	}
	
	// Getter
	public String getType() {
		return this.type;
	}
}
