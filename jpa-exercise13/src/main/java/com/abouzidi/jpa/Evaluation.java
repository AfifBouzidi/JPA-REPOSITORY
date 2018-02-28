package com.abouzidi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Evaluation {

	@SequenceGenerator(name = "evaluation_gen", sequenceName = "evaluation_seq")
	@Id
	@GeneratedValue(generator = "evaluation_gen")
	private long id;

	private long eval;

	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Employee employee;

	public Evaluation() {

	}

	public Evaluation(long eval) {
		this.eval = eval;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

		public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
