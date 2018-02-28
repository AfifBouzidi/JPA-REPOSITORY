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
		emp.setEmails(Arrays.asList("test@test.com", "test1@test.com", "test.test@test.com"));
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		// assertNull("Salary from database",employee.getSalary());

	}

}
