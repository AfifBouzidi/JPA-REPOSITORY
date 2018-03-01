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

		QualityProject quality = new QualityProject();
		quality.setName("QualityP");
		quality.setQualityCode("QCODE");
		DesignProject design = new DesignProject();
		design.setName("DesignP");
		design.setDesignCode("DCODE");
		em.getTransaction().begin();
		em.persist(quality);
		em.persist(design);
		em.getTransaction().commit();
		Project project=em.find(QualityProject.class,1l);
		assertNotNull("Project from database",project);
	}

}
