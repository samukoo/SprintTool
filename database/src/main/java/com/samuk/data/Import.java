package com.samuk.data;

import java.io.File;
import java.io.FileInputStream;

public class Import {

	
	public File readExcell() throws Exception{
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sprintcalculator.xlsx").getFile());
		FileInputStream fis = new FileInputStream(file);
		
		return file;
	}
	
	
}
