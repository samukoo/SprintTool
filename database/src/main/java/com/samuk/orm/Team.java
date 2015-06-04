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
	String team_name;
	String team_description;
	
	public Team(){}
	
	public Team(String team_name, String team_description) {
		super();
		this.team_name = team_name;
		this.team_description = team_description;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_description() {
		return team_description;
	}

	public void setTeam_description(String team_description) {
		this.team_description = team_description;
	}

	@Override
	public String toString() {
		return "Team [eid=" + eid + ", team_name=" + team_name
				+ ", team_description=" + team_description + "]";
	}
	
	
	
}
