package com.samuk.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.Team;

public class TeamOperations{

	
	
	public Team create(Team t) {

		
		EntityManager em = Producer.getEntityManager();	
		
		em.persist(t);
		em.getTransaction().commit();
		em.clear();
		
		return t;
	}

	public Team update(Team t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Team find(Long id) {
		EntityManager em = Producer.getEntityManager();
		return em.find(Team.class, id);
	}

	public void remove(Long id) {
		EntityManager em = Producer.getEntityManager();
		em.remove(em.find(Team.class, id));
		em.clear();
	}

	public List<Team> listAll() {
		EntityManager em = Producer.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Team> q = cb.createQuery(Team.class);
		Root<Team> team = q.from(Team.class);
		q.select(team);
		return em.createQuery(q).getResultList();
		
	}


}
