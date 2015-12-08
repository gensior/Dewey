package com.jfranceschini.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileLogger extends AbstractLogger {

	public FileLogger(Class clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public OutputStream makeOutputStream() {
		String homeDir = System.getProperty("user.home");
		String logFilePath = homeDir+"/clazzlog.txt";
		
		// TODO Auto-generated method stub
		try {
			if(!Files.exists(Paths.get(logFilePath))) {
				Files.createFile(Paths.get(logFilePath));
			}
			return new FileOutputStream(new File(logFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return System.out;
		}
		
	}

}
