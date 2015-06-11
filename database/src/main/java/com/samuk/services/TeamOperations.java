package com.samuk.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	@Override
	public List<Team> listAll() {
		em = Producer.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Team> q = cb.createQuery(Team.class);
		Root<Team> team = q.from(Team.class);
		q.select(team);
		return em.createQuery(q).getResultList();
		
//		TypedQuery<Team> q = em.createQuery("SELECT t FROM Team t", Team.class);
//		return q.getResultList();
	}


}
