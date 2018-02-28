package com.abouzidi.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

	@SequenceGenerator(name="emp_gen",sequenceName="emp_seq")
	@Id
	@GeneratedValue(generator="emp_gen")
	private long id;

	private String name;

	private int salary;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="parking_id")
	private ParkingPlace parkingPlace;

	public Employee() {

	}

	public Department getDepartment() {
		return department;
	}


	public ParkingPlace getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(ParkingPlace parkingPlace) {
		this.parkingPlace = parkingPlace;
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
