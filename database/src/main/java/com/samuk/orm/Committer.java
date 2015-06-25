package com.samuk.orm;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Committer implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public long id;
	public int committedPoints;
	
	@OneToOne
	@JoinColumn(nullable=true)
	public Member member;
	
	@OneToOne
	@JoinColumn(nullable=true)
	public Sprint sprint;
	
	public Committer() {
		super();
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getCommittedPoints() {
		return committedPoints;
	}

	public void setCommittedPoints(int committedPoints) {
		this.committedPoints = committedPoints;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "Committer [id=" + id + ", member=" + member
				+ ", committedPoints=" + committedPoints + ", sprint=" + sprint
				+ "]";
	}

	
	
	
	
	
}
