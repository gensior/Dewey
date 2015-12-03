package com.jfranceschini.library.exception;

/**
 * LibraryItemDoesNotExistException
 * @author Jesse Franceschini
 *
 */
public class LibraryItemDoesNotExistException extends Exception {

	/** long of serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor
	 */
	public LibraryItemDoesNotExistException(){
		super("Item does not exist.");
	}

	/**
	* Constructor
	* @param message a String of a custom error message
	*/
	public LibraryItemDoesNotExistException(String message) {
		super(message);
	}
	
}