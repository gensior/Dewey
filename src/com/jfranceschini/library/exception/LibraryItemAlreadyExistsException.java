package com.jfranceschini.library.exception;

/**
 * LibraryItemAlreadyExistsException
 * @author Jesse Franceschini
 *
 */
public class LibraryItemAlreadyExistsException extends Exception {

	/** long of the serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor
	 */
	public LibraryItemAlreadyExistsException(){
		super("Item already exists.");
	}

	/**
	* Constructor
	* @param message a String of a custom error message
	*/
	public LibraryItemAlreadyExistsException(String message) {
		super(message);
	}
	
}
