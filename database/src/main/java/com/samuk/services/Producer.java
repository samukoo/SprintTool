package com.samuk.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Producer {

	private static EntityManager em = null;
	
	public static EntityManager getEntityManager(){
		EntityManagerFactory emf = null;

		emf = Persistence.createEntityManagerFactory("sprint_tool");
//		emf = Persistence.createEntityManagerFactory("sprint_tool");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	
}
