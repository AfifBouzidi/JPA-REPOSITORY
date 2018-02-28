package com.abouzidi.jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Employee {

	@EmbeddedId
	private EmployeeId id;

	private String name;

	private int salary;

	public Employee() {

	}

	public Employee(Long id, String country, String name, int salary) {
		this.id = new EmployeeId(id, country);
		this.name = name;
		this.salary = salary;
	}

	public String getCountry() {
		return id.getCountry();
	}

	public long getId() {
		return id.getId();
	}

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
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
