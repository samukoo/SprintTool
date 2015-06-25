package com.samuk.services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.Sprint;

public class SprintOperations{

	EntityManager em = Producer.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	public SprintOperations(){}
	

	public Sprint create(Sprint sprint) {
		EntityManager em = Producer.getEntityManager();
		EntityTransaction tx = em.getTransaction();	
		
		em.persist(sprint);
		tx.commit();		
		em.clear();
		return sprint;
	}

	public Sprint update(Sprint t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Sprint find(Long id) {
		return em.find(Sprint.class, id);
	}

	public void remove(Long id) {
		em.remove(em.find(Sprint.class, id));
		tx.commit();
		em.clear();
	}


	public List<Sprint> listAll() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sprint> q = cb.createQuery(Sprint.class);
		Root<Sprint> sprint = q.from(Sprint.class);
		q.select(sprint);
		return em.createQuery(q).getResultList();
	}


	
}
