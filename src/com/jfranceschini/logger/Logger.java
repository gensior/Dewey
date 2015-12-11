package com.jfranceschini.logger;

/**
 * Logger
 * @author Jesse Franceschini
 *
 */
public interface Logger {

	/** info log method */
	public void info(String message);
	
	/** warn log method */
	public void warn(String message);
	
	/** error log method */
	public void error(String message);
}
