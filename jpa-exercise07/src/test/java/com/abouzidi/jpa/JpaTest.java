package com.abouzidi.jpa;

import static org.junit.Assert.*;

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
		Address address=new Address("AB","T","TN","14uz");
		Employee emp1=new Employee("Afif",1200);
		Employee emp2=new Employee("Bouzidi",1300);
		Employee emp3=new Employee("ABouzidi",1800);
		emp1.setAddress(address);
		emp2.setAddress(address);
		emp3.setAddress(address);
		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.getTransaction().commit();
		
		assertNotNull("Employee from database", emp1.getId());
	}

}
