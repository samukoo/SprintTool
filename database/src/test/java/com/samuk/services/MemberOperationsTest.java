package com.samuk.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.samuk.data.Import;
import com.samuk.orm.Member;
import com.samuk.orm.Role;

public class MemberOperationsTest {

	private MemberOperations memOps = new MemberOperations();
	private String deleteQuery = "DELETE FROM Member m";

//	@Before
	public void setup() {
		// setup
		System.out.println("Clear table");
		EntityManager em = Producer.getEntityManager();
		em.createQuery(deleteQuery).executeUpdate();
		em.getTransaction().commit();
		em.clear();
		em.close();
		System.out.println("Clear table done");
	}

//	@Test
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

//	@Test
	public void test_Find_and_Delete_user() throws InterruptedException {
		Member member = new Member("Delete TestUser", Role.testaaja, null);
		
		memOps.create(member);
		System.out.println("create done");
		
		memOps.remove(1L);
		System.out.println("remove done");
		assertNull(memOps.find(1L));
	}

//	@Test
	public void IT_import_members_and_save_into_DB()throws Exception{
		Import i = new Import();
		
		for(int j = 0; j < i.readMembers().size(); j++)
			memOps.create(i.readMembers().get(j));
	}
	
//	@Test
	public void get_all_members_as_list(){
		Iterator<Member> im = memOps.listAll().iterator();
		while(im.hasNext()){
			System.out.println(im.next().getName());
		}
		
	}
	
}
