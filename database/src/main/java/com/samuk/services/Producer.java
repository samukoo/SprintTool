package com.samuk.services;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Producer {

	
	public static EntityManager getEntityManager(){
		EntityManager em = Persistence.createEntityManagerFactory("sprint_tool").createEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	
}
