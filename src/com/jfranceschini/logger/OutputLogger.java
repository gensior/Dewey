package com.jfranceschini.logger;

import java.io.OutputStream;

public class OutputLogger extends AbstractLogger {

	public OutputLogger(Class clazz) {
		super(clazz);
	}
	
	public OutputStream makeOutputStream() {
		return System.out;
	}

}
