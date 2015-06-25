package com.samuk.services;

import org.junit.Test;

import com.samuk.orm.Committer;
import com.samuk.orm.Member;
import com.samuk.orm.Sprint;

public class CommitterOperationsTest {

	CommitterOperations comOps = new CommitterOperations();
	MemberOperations memOps = new MemberOperations();
	SprintOperations spiOps = new SprintOperations();
	
	public CommitterOperationsTest() {
	}
	
	@Test
	public void crateNewCommit_test(){
		
		Member m = memOps.find(3L);
		Sprint s = spiOps.find(2L);
		
		
		Committer c = new Committer();
		c.setCommittedPoints(22);
		c.setMember(m);
		c.setSprint(s);
		
		comOps.createCommit(c);
		
		
		
		
		
		
		
		
		
	}
	
}
