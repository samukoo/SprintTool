package com.samuk.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.samuk.orm.Member;
import com.samuk.orm.Team;

public class MemberOperations{

	private EntityManager em = null;

	public Member create(Member member) {
		em = Producer.getEntityManager();
		em.persist(member);
		em.getTransaction().commit();
		em.clear();
		return member;
	}

	public Member update(Member t) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * remove by ID
	 * @param mid
	 */
	public void remove(Long mid) {
		em = Producer.getEntityManager();
		em.remove(em.find(Member.class, mid));
		em.getTransaction().commit();
		em.clear();

	}
	
	/**
	 * Find by ID
	 * @param mid
	 * @return
	 */
	public Member find(Long mid) {
		em = Producer.getEntityManager();
		Member member = em.find(Member.class, mid);
		em.clear();
		return member;
	}

	/**
	 * find by name
	 * @param name
	 * @return
	 */
	public Member find(String name){
		Member member = null;
		return member;
	}
	
	
	public List<Member> listAll() {
		em = Producer.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> query = cb.createQuery(Member.class);
		Root<Member>mem = query.from(Member.class);
		query.select(mem);
		return em.createQuery(query).getResultList();
	}

	public List<Member> listAllTeamMembers(Team team) {
		em = Producer.getEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Member> query = cb.createQuery(Member.class);
		Root<Member> member = query.from(Member.class);
		query.where(cb.equal(member.get("team"), team));

		return em.createQuery(query).getResultList();
	}

}
