package com.samuk.services;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.samuk.orm.Team;

public class TeamOperationsTest {

	TeamOperations teaOps = new TeamOperations();
	private String deleteQuery = "DELETE FROM Team t";

//	@Before
	public void setup() {
		// setup
		System.out.println("Clear table");
		EntityManager em = Producer.getEntityManager();
		em.createQuery(deleteQuery).executeUpdate();
		em.getTransaction().commit();
		em.clear();
		em.close();
		System.out.println("Clear done");

	}

	@Test
	public void test_create_new_team() {
		Team team = new Team("SQL", "Sql development");
		teaOps.create(team);
		
	}

}
