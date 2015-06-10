package com.samuk.services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.samuk.orm.Sprint;

public class SprintOperations implements ObjectOperations<Sprint>{

	EntityManager em = null;
	
	public SprintOperations(){}
	

	@Override
	public Sprint create(Sprint sprint) {
		em = Producer.getEntityManager();
		em.persist(sprint);
		em.getTransaction().commit();
		em.close();
		return sprint;
	}

	@Override
	public Sprint update(Sprint t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sprint find(Long id) {
		em = Producer.getEntityManager();
		return em.find(Sprint.class, id);
	}

	@Override
	public void remove(Long id) {
		em = Producer.getEntityManager();
		em.remove(em.find(Sprint.class, id));
		em.getTransaction().commit();
		em.close();
		
	}


	@Override
	public List<Sprint> listAll() {
		em = Producer.getEntityManager();
		TypedQuery<Sprint> q = em.createQuery("SELECT s FROM Sprint s", Sprint.class);
		return q.getResultList();
	}


	
}
