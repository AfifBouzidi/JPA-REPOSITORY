package com.abouzidi.jpa;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
		employee.setParkingPlace(parkingPlace);
		employee.setDepartment(department);
		department.setEmployees(Arrays.asList(employee));
		em.getTransaction().begin();
		em.persist(department);
		em.getTransaction().commit();
		
        TypedQuery<Employee> query= em.createNamedQuery("findEmployeeByNameAndId",Employee.class);
        query.setParameter("name", "Afif");
        query.setParameter("id",1l);
        Employee emp=query.getSingleResult();
		assertNotNull("Employee from database",emp);
		
		TypedQuery<Employee> queryDynamic= em.createQuery("select e from Employee e where e.id = :id",Employee.class);
		queryDynamic.setParameter("id", 1l);
		emp=queryDynamic.getSingleResult();
		assertNotNull("Employee from database",emp);
		
	}

}
