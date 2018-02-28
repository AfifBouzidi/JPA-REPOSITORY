package com.abouzidi.jpa;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

		EmployeeId id1 = new EmployeeId(1L, "Tunisia");
		EmployeeId id2 = new EmployeeId(2L, "Tunisia");
		EmployeeId id3 = new EmployeeId(3L, "Tunisia");

		Employee emp1 = new Employee(1L, "Tunisia", "Afif", 1200);
		Employee emp2 = new Employee(2L, "Tunisia", "Bouzidi", 1300);
		Employee emp3 = new Employee(3L, "Tunisia", "ABouzidi", 1800);
		em.getTransaction().begin();
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
		em.getTransaction().commit();

		Employee employee1 = em.find(Employee.class, id1);
		Employee employee2 = em.find(Employee.class, id2);
		Employee employee3 = em.find(Employee.class, id3);
		assertNotNull("Employee from database", employee1);
		assertNotNull("Employee from database", employee2);
		assertNotNull("Employee from database", employee3);

		TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id.id = :id and e.id.country = :country",
				Employee.class);
		query.setParameter("id", 1l);
		query.setParameter("country", "Tunisia");
		Employee employee = query.getSingleResult();
		assertNotNull("Employee from database", employee);

	}

}
