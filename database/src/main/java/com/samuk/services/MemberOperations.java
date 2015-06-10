package com.samuk.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.samuk.orm.Member;

public class MemberOperations implements ObjectOperations<Member> {

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
		Member member = em.find(Member.class, mid);
		em.close();
		return member;
	}

	@Override
	public List<Member> listAll() {
		em = Persistence.createEntityManagerFactory("sprint_tool").createEntityManager();
		TypedQuery<Member> q = em.createQuery("SELECT m FROM Member m", Member.class);
		return q.getResultList();
	}

}
