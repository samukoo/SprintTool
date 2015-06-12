package com.samuk.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long eid;
	String name;
	String description;
	
	public Team(){}
	
	public Team(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String team_name) {
		this.name = team_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String team_description) {
		this.description = team_description;
	}

	@Override
	public String toString() {
		return "Team [eid=" + eid + ", team_name=" + name
				+ ", description=" + description + "]";
	}
	
}
