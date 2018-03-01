package com.abouzidi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ParkingPlace {

	@SequenceGenerator(name = "parking_gen", sequenceName = "parking_seq")
	@Id
	@GeneratedValue(generator = "parking_gen")
	private long id;

	private String location;

	@OneToOne(mappedBy = "parkingPlace")
	private Employee employee;

	public ParkingPlace() {

	}

	public ParkingPlace(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
