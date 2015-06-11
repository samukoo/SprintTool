package com.samuk.data;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.samuk.orm.Member;

public class ImportTest {

	Import i = new Import();
	
//	@Test
	public void testImport()throws Exception{
		
		assertNotNull(i.readExcell());
		
	}
	
//	@Test
	public void members_are_listed()throws Exception{
		
		List<Member> res = i.readMembers();
		assertNotNull(res);
		
		for(Member m : i.readMembers())
			System.out.println(m.getName());
		
		
	}
	
	
}
