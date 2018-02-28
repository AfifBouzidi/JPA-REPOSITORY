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
		
		EmployeeId id1=new EmployeeId(1L,"Tunisia");
		EmployeeId id2=new EmployeeId(2L,"Tunisia");
		EmployeeId id3=new EmployeeId(3L,"Tunisia");
		//EmployeeId id4=new EmployeeId(4L,"Tunisia");
		
		Employee emp1=new Employee(1L,"Tunisia","Afif",1200);
		Employee emp2=new Employee(2L,"Tunisia","Bouzidi",1300);
		Employee emp3=new Employee(3L,"Tunisia","ABouzidi",1800);
		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.getTransaction().commit();
		
		Employee employee1 = em.find(Employee.class, id1);
		Employee employee2 = em.find(Employee.class, id2);
		Employee employee3 = em.find(Employee.class, id3);
		//Employee employee4 = em.find(Employee.class, id4);
		assertNotNull("Employee from database", employee1);
		assertNotNull("Employee from database", employee2);
		assertNotNull("Employee from database", employee3);
		//assertNotNull("Employee from database", employee4);
	}

}
