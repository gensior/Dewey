package com.jfranceschini.logger;

import java.io.IOException;
import java.io.OutputStream;

/**
 * AbstractLogger
 * @author Jesse Franceschini
 *
 */
public abstract class AbstractLogger implements Logger {
	
	/** Log Level string for INFO */
	private final String INFO = "INFO";
	/** Log Level string for WARN */
	private final String WARN = "WARN";
	/** Log Level string for ERROR */
	private final String ERROR = "ERROR";
	/** A String of the class name to associate with the logger */
	private final String className;
	/** An OutputStream used by the logger */
	private final OutputStream out;

	/**
	 * Default Constructor
	 * @param clazz a Class object to associate with the Logger
	 */
	public AbstractLogger(@SuppressWarnings("rawtypes") Class clazz) {
		this.className = clazz.getName();
		this.out = makeOutputStream();
	}
	
	/**
	 * Abstract method to be fulfilled by inherited classes
	 * @return an OutputStream
	 */
	public abstract OutputStream makeOutputStream();
	
	/**
	 * Logs messages with the INFO level
	 */
	public void info(String message) {
		writeMessage(INFO, message);
	}
	
	/**
	 * Logs messages with the WARN level
	 */
	public void warn(String message) {
		writeMessage(WARN, message);
	}
	
	/**
	 * Logs messages with the ERROR level
	 */
	public void error(String message) {
		writeMessage(ERROR, message);
	}
	
	/**
	 * Writes messages to the output stream
	 * @param errorLevel a String representing the log level
	 * @param message a String representing the message to log
	 */
	private void writeMessage(String errorLevel, String message) {
		try {
			out.write(String.format("[" + errorLevel + "] " + className + ": " + message + "\n").getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Factory method to create a logger based on LoggerType
	 * @param loggerType an enum class that allows for either CONSOLE or FILE
	 * @param clazz the class to associate with the Logger
	 * @return a Logger interface of either OutputLogger or FileLogger
	 */
	public static Logger createLogger(LoggerType loggerType, @SuppressWarnings("rawtypes") Class clazz) {
		if (loggerType == LoggerType.CONSOLE) {
			return new OutputLogger(clazz);
		} else {
			return new FileLogger(clazz);
		}
	}
}
