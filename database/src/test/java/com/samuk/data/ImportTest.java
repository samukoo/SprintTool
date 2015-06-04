package com.samuk.data;

import static org.junit.Assert.*;
import org.junit.Test;

public class ImportTest {

	Import i = new Import();
	
	@Test
	public void testImport()throws Exception{
		
		assertNotNull(i.readExcell());
		
		
		
	}
	
}
