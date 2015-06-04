package com.samuk.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.samuk.orm.Member;
import com.samuk.orm.Role;

public class MemberOperationsTest {

	private MemberOperations memOps = new MemberOperations();
	private String deleteQuery = "DELETE FROM Member m";

	@Before
	public void setup() {
		// setup
		System.out.println("Clear table");
		EntityManager em = Producer.getEntityManager();
		em.createQuery(deleteQuery).executeUpdate();
		em.getTransaction().commit();
		em.clear();
		em.close();
		System.out.println("Clear done");
	}

	@Test
	public void test_Create_Member_and_find() {

		Member member = new Member("Testi Nimi", Role.devaaja, null);
		assertNotNull(memOps.create(member));
		assertNotNull(memOps.find(1L));
		System.out.println(memOps.find(1L).toString());
	}

//	@Test
	public void test_Find_Member_by_mid() {
		Member member = new Member("Find TestUser", Role.testaaja, null);
		memOps.create(member);

		Member res = memOps.find(1L);
		assertEquals(member.getName(), res.getName());
		System.out.println(res.toString());
	}

	@Test
	public void test_Find_and_Delete_user() {
		Member member = new Member("Delete TestUser", Role.testaaja, null);
		memOps.create(member);
		assertNotNull(memOps.find(1L));
		memOps.remove(1L);
		assertNull(memOps.find(1L));
	}

}
