package com.abouzidi.jpa;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@SequenceGenerator(name="emp_gen",sequenceName="emp_seq")
	@Id
	@GeneratedValue(generator="emp_gen")
	private long id;

	private String name;

	private int salary;

	public Employee() {

	}

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	

	@OneToMany(mappedBy="employee")
	private Collection<ProjectAssignment> assignments;


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}



	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Collection<ProjectAssignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Collection<ProjectAssignment> assignments) {
		this.assignments = assignments;
	}

}
