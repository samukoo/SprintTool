package com.samuk.services;

import org.junit.Test;

import com.samuk.data.Import;
import com.samuk.orm.Sprint;


public class SprintOperationsTest {

    SprintOperations sprOps = new SprintOperations();
	
    @Test
	public void saveSprints()throws Exception {
		Import i = new Import();
		
		for(Sprint s : i.readExcell())
			sprOps.create(s);
		
		
	}
	
}
