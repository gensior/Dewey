package com.jfranceschini.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger extends AbstractLogger {

	public FileLogger(@SuppressWarnings("rawtypes") Class clazz) {
		super(clazz);
	}

	@Override
	public OutputStream makeOutputStream() {
		String homeDir = System.getProperty("user.home");
		String logFilePath = homeDir+"/clazzlog.txt";
		
		try {
			if(!Files.exists(Paths.get(logFilePath))) {
				Files.createFile(Paths.get(logFilePath));
			}
			return new FileOutputStream(new File(logFilePath));
		} catch (IOException e) {
			System.out.println("File not found!");
			e.printStackTrace();
			return System.out;
		}
		
	}

}
