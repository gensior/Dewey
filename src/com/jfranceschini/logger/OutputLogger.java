package com.jfranceschini.logger;

import java.io.OutputStream;

/**
 * OutputLogger
 * @author Jesse Franceschini
 *
 */
public class OutputLogger extends AbstractLogger {

	/**
	 * OutputLogger
	 * @param clazz a Class object of the class to associate to the Logger
	 */
	public OutputLogger(@SuppressWarnings("rawtypes") Class clazz) {
		super(clazz);
	}
	
	@Override
	/**
	 * Creates a console output stream
	 * @return an OutputStream
	 */
	public OutputStream makeOutputStream() {
		return System.out;
	}

}
