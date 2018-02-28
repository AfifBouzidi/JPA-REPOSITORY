package com.abouzidi.jpa;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

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
		Employee emp1 = new Employee("Bouzidi", 1200);
		Employee emp2 = new Employee("Abouzidi", 1300);
		Employee emp3 = new Employee("Afif", 1800);
		emp1.setCode("E1");
		emp2.setCode("E2");
		emp3.setCode("E3");
		Department dep = new Department("ING");

		dep.getEmployees().put("E1", emp1);
		dep.getEmployees().put("E2", emp2);
		dep.getEmployees().put("E3", emp3);
		
		emp1.setDepartment(dep);
		emp2.setDepartment(dep);
		emp3.setDepartment(dep);
		
		em.getTransaction().begin();
		em.persist(dep);
		em.getTransaction().commit();
		Department department=em.find(Department.class, 1l);
		assertNotNull("Salary from database",department.getEmployees().get("E1"));

	}

}
