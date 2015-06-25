package com.samuk.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.samuk.orm.Committer;

public class CommitterOperations {

	EntityManager em = Producer.getEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	
	public Committer createCommit(Committer c){
		em.persist(c);

		tx.commit();
		
		em.clear();
		return c;
	}
	
	
	
	
	
	
	
}
