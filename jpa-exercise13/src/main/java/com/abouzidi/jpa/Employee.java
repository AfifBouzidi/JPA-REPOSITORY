package com.abouzidi.jpa;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@SequenceGenerator(name="emp_gen",sequenceName="emp_seq")
	@Id
	@GeneratedValue(generator="emp_gen")
	private long id;

	private String name;

	@Column(insertable=false, updatable=false)
	private Integer salary;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	@OneToMany(mappedBy="employee",orphanRemoval=true,cascade=CascadeType.PERSIST)
	private Collection<Evaluation> evals;

	public Employee() {

	}

	public Department getDepartment() {
		return department;
	}

	
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public Collection<Evaluation> getEvals() {
		return evals;
	}

	public void setEvals(Collection<Evaluation> evals) {
		this.evals = evals;
	}

}
