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
		Department dept=new Department("ING");
		Employee emp = new Employee("Bouzidi", 1200);
		Evaluation eval= new Evaluation(10l);
		emp.setEvals(Arrays.asList(eval));
		eval.setEmployee(emp);
		dept.setEmployees(Arrays.asList(emp));
		emp.setDepartment(dept);
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
		em.clear();
		Employee employee=em.find(Employee.class,emp.getId());
		assertNull("Salary from database",employee.getSalary());
		
	}

}
