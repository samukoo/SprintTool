package com.samuk.data;

public class Util {

	
	/**
	 * Argument string is converted first to Double value, and after that casted to int
	 * @param string ("3.0")
	 * @return int(3) 
	 */
	public static int parseInt(String string){
		return (int)Double.parseDouble(string);
	}
	
	public static Double parseDouble(String string){
		return Double.parseDouble(string);
	}
	
	
	
}
