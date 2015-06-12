package com.samuk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	private InputStream i = null;

	public Properties getProperties(String file) {

		i = getClass().getClassLoader().getResourceAsStream(file);

		Properties prop = new Properties();

		try {
			prop.load(i);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
