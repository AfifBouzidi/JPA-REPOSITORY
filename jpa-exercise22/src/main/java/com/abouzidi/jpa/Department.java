package com.abouzidi.jpa;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	
	@SequenceGenerator(name="dept_gen",sequenceName="dept_seq")
	@Id
	@GeneratedValue(generator="dept_gen")
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private Collection<Employee> employees;

	public Department() {

	}
	
	public Department(String name) {
		this.name = name;
	}

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
