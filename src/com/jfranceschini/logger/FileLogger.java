package com.jfranceschini.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * FileLogger
 * @author Jesse Franceschini
 *
 */
public class FileLogger extends AbstractLogger {

	/**
	 * FileLogger
	 * @param clazz a Class object to associate with the Logger
	 */
	public FileLogger(@SuppressWarnings("rawtypes") Class clazz) {
		super(clazz);
	}

	@Override
	/**
	 * Creates a file-based output stream
	 * @return a FileOutputStream object
	 */
	public OutputStream makeOutputStream() {
		String homeDir = System.getProperty("user.home");
		String logFilePath = homeDir+"/clazzlog.txt";
		
		try {
			if(!Files.exists(Paths.get(logFilePath))) {
				Files.createFile(Paths.get(logFilePath));
			}
			FileOutputStream fos = new FileOutputStream(new File(logFilePath));
			return fos;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
