package com.abouzidi.jpa;

import static org.junit.Assert.*;

import java.util.Arrays;

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
		Department department =new Department("ENG");
		ParkingPlace parkingPlace=new ParkingPlace("ouest");
		Employee employee=new Employee("Afif",1200);
		Employee employee1=new Employee("AB",1200);
		employee.setParkingPlace(parkingPlace);
		employee.setDepartment(department);
		department.setEmployees(Arrays.asList(employee,employee1));
		em.getTransaction().begin();
		em.persist(department);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Query updateQuery= em.createQuery("update Employee e SET e.salary = :salary where e.id = :id");
		updateQuery.setParameter("id", 1l);
		updateQuery.setParameter("salary", 2000);
		updateQuery.executeUpdate();
		
		Query deleteQuery= em.createQuery("Delete Employee e where e.id = :id");
		deleteQuery.setParameter("id", 2l);
		deleteQuery.executeUpdate();
		em.getTransaction().commit();
		em.clear();
		
		
		Employee emp=em.find(Employee.class, 1l);
		assertEquals("salary from DB",2000,emp.getSalary());
		assertNull("Employee from database",em.find(Employee.class, 2l));
		
	}

}
