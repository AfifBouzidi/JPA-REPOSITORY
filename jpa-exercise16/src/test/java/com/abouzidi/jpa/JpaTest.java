package com.abouzidi.jpa;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Date;

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
		Project project = new Project("ENG");
		ProjectAssignment pa=new ProjectAssignment();
		pa.setStartDate(new Date());
		pa.setEmployee(emp);
		pa.setProject(project);
		em.getTransaction().begin();
		em.persist(emp);
		em.persist(project);
		em.persist(pa);
		em.getTransaction().commit();
		ProjectAssignment projectAssignment=em.find(ProjectAssignment.class, new ProjectAssignmentId(1,1));
		assertNotNull("Employee from database", projectAssignment);
	}

}
