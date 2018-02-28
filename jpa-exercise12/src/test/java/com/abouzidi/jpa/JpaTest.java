package com.abouzidi.jpa;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JpaTest {

	private static EntityManager em;
	private static EntityManagerFactory emf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		emf = Persistence.createEntityManagerFactory("jpa-pu");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		em.close();
		emf.close();
	}

	@Test
	public void test() {
		Employee emp = new Employee("Bouzidi", 1200);
		Phone phone = new Phone(PhoneType.SAMSUNG);
		emp.setPhones(Arrays.asList(phone));
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		// assertNotNull("Employee from database", emp1.getId());
	}

}
