package com.jfranceschini.library.exception;

/**
 * LibraryMemberDoesNotExistException
 * @author Jesse Franceschini
 *
 */
public class LibraryMemberDoesNotExistException extends Exception {

	/** long of serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor
	 */
	public LibraryMemberDoesNotExistException(){
		super("Library Member does not exist.");
	}

	/**
	* Constructor
	* @param message a String of a custom error message
	*/
	public LibraryMemberDoesNotExistException(String message) {
		super(message);
	}

}
