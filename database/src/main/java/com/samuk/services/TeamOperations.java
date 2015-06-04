package com.samuk.services;

import javax.persistence.EntityManager;

import com.samuk.orm.Team;

public class TeamOperations implements ObjectOperations<Team> {

	EntityManager em = Producer.getEntityManager();

	@Override
	public Team create(Team t) {
		em.persist(t);
		em.getTransaction().commit();
		em.close();

		return t;
	}

	@Override
	public Team update(Team t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team find(Long id) {
		em = Producer.getEntityManager();
		return em.find(Team.class, id);
	}

	@Override
	public void remove(Long id) {
		em = Producer.getEntityManager();
		em.remove(em.find(Team.class, id));
		em.getTransaction().commit();
		em.close();
	}


}
