package com.samuk.orm;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sprint {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long eid;
	int week;

	@Temporal(TemporalType.DATE)
	Date date;
	
	@OneToOne
	@JoinColumn(nullable=true)
	Team team;
	
	String description;
	
	
	public Sprint(){}

	public Sprint(int week, Team team, String description) {
		super();
		this.week = week;
		this.team = team;
	}


	
	
	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}


	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Sprint [eid=" + eid + ", week=" + week + ", date=" + date
				+ ", team=" + team + "]";
	}

	

	
	
	
}
