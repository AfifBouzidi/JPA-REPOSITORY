package com.abouzidi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {

	@TableGenerator(name = "EMPLOYEE_GEN", table = "TAb_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "EMP_Gen", initialValue = 10000, allocationSize = 100)
	@Id
	@GeneratedValue(generator = "EMPLOYEE_GEN")
	private long id;

	private String name;

	private int salary;

	public Employee() {

	}

	public Employee(String name, int salary) {
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
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
