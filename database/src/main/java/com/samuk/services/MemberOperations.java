package com.samuk.services;

import javax.persistence.EntityManager;

import com.samuk.orm.Member;


public class MemberOperations implements ObjectOperations<Member>{

	EntityManager em = null;
	
	
	@Override
	public Member create(Member member) {
		em = Producer.getEntityManager();
		em.persist(member);
		em.getTransaction().commit();
		em.close();
		return member;
	}

	@Override
	public Member update(Member t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long mid) {
		em = Producer.getEntityManager();
		em.remove(em.find(Member.class, mid));
		em.getTransaction().commit();
		em.close();
		
		
	}

	@Override
	public Member find(Long mid) {
		em = Producer.getEntityManager();
		return em.find(Member.class, mid);
	}

	




}
