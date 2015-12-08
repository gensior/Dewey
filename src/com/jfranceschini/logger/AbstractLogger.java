package com.jfranceschini.logger;

import java.io.IOException;
import java.io.OutputStream;

public abstract class AbstractLogger implements Logger {
	
	private final String INFO = "INFO: ";
	private final String WARN = "WARN: ";
	private final String ERROR = "ERROR: ";
	
	private final String className;
	private final OutputStream out;

	public AbstractLogger(Class clazz) {
		className = clazz.getName();
		this.out = makeOutputStream();
	}
	
	public abstract OutputStream makeOutputStream();
	
	public enum LoggerType {
		CONSOLE, FILE;
		
		private LoggerType() {}
	}
	
	public void info(String message) {
		writeMessage(INFO, message);
	}
	
	public void warn(String message) {
		writeMessage(WARN, message);
	}
	
	public void error(String message) {
		writeMessage(ERROR, message);
	}
	
	private void writeMessage(String errorLevel, String message) {
		try {
			out.write(String.format(className+": " + errorLevel + message + "\n").getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Logger createLogger(LoggerType loggerType, Class clazz) {
		if (loggerType == LoggerType.CONSOLE) {
			return new OutputLogger(clazz);
		} else {
			return new FileLogger(clazz);
		}
	}
}