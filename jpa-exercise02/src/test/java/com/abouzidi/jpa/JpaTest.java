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
		Employee emp1=new Employee(1,"Afif",1200);
		Employee emp2=new Employee(2,"Bouzidi",1300);
		Employee emp3=new Employee(3,"ABouzidi",1800);
		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.getTransaction().commit();
		
		Employee employee = em.find(Employee.class, 1L);
		assertNotNull("Employee from database", employee);
	}

}
