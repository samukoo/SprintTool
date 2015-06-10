package com.samuk.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.samuk.orm.Sprint;

public class SprintOperationsTest {

	SprintOperations spiOps = new SprintOperations();

//	@Test
	public void add_Sprints_to_DB() {

		List<Sprint> sprintList = new ArrayList<Sprint>();
		Sprint s1 = new Sprint(1, null, "week 1");
		Sprint s2 = new Sprint(2, null, "week 2");
		sprintList.add(s1);
		sprintList.add(s2);
		
		for (Sprint sprint : sprintList)
			spiOps.create(sprint);

	}

}
