package com.jfranceschini.logger;

import java.io.OutputStream;

public class OutputLogger extends AbstractLogger {

	public OutputLogger(@SuppressWarnings("rawtypes") Class clazz) {
		super(clazz);
	}
	
	public OutputStream makeOutputStream() {
		return System.out;
	}

}
