package com.samuk.orm;

import java.util.List;

public class Container {

	List<Sprint> sprintList;
	List<Committer> committerList;
	public List<Sprint> getSprintList() {
		return sprintList;
	}
	public void setSprintList(List<Sprint> sprintList) {
		this.sprintList = sprintList;
	}
	public List<Committer> getCommitterList() {
		return committerList;
	}
	public void setCommitterList(List<Committer> committerList) {
		this.committerList = committerList;
	}
	
	
	
}
