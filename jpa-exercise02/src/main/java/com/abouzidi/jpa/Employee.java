package com.abouzidi.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPLOYEE")
public class Employee {

	@Id
	@Column(name="EMP_ID")
	private long id;

	@Column(name="EMP_NAME")
	private String name;

	@Column(name="EMP_SALARY")
	private int salary;

	public Employee() {

	}

	public Employee(long id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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

	

}
