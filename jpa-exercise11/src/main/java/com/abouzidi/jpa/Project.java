package com.abouzidi.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {

	@SequenceGenerator(name="prj_gen",sequenceName="prj_seq")
	@Id
	@GeneratedValue(generator="prj_gen")
	private long id;

	private String name;

	public Project() {
	}
	
	public Project(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy="projects")
	private Collection<Employee> employees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
}
