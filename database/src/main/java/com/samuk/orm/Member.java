package com.samuk.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long mid;
	private String name;
	private Role role;

	@ManyToOne
	@JoinColumn(nullable=true, referencedColumnName = "eid")
	private Team team;

	public Member(){}

	public Member(String name, Role role, Team team) {
		super();
		this.name = name;
		this.role = role;
		this.team = team;
	}

	
	
	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
