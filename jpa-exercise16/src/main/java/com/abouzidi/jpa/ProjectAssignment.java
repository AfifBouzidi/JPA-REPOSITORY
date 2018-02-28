package com.abouzidi.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@IdClass(ProjectAssignmentId.class)
public class ProjectAssignment {

	@Id
	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	private Employee employee;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE", updatable = false)
	private Date startDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
