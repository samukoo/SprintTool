package com.samuk.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
//@NamedQuery(query="Select s FROM sprint s", name = "get all sprints")
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long eid;
	int week;
	
	@OneToOne
	@JoinColumn(nullable=true)
	Team team;
	String description;
	
	public Sprint(){}

	public Sprint(int week, Team team, String description) {
		super();
		this.week = week;
		this.team = team;
		this.description = description;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Sprint [eid=" + eid + ", week=" + week + ", team=" + team
				+ ", description=" + description + "]";
	}

	
	
	
}
