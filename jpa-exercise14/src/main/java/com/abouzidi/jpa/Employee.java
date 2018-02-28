package com.abouzidi.jpa;

import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@SequenceGenerator(name = "emp_gen", sequenceName = "emp_seq")
	@Id
	@GeneratedValue(generator = "emp_gen")
	private long id;

	private String name;

	private int salary;

	@ElementCollection
	@CollectionTable(name = "EMP_EMAIL", joinColumns = @JoinColumn(name = "EMP_ID"))
	@Column(name="EMPLOYEE_EMAIL")
	private Collection<String> emails;

	public Employee() {
	}

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public Collection<String> getEmails() {
		return emails;
	}

	public void setEmails(Collection<String> emails) {
		this.emails = emails;
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
