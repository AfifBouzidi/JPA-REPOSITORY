package com.abouzidi.jpa;

import java.io.Serializable;

public class ProjectAssignmentId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6312263179132956577L;

	private long employee;
	
	private long project;
	
	
	
	public ProjectAssignmentId() {
	}

	public ProjectAssignmentId(long employee, long project) {
		this.employee = employee;
		this.project = project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employee ^ (employee >>> 32));
		result = prime * result + (int) (project ^ (project >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectAssignmentId other = (ProjectAssignmentId) obj;
		if (employee != other.employee)
			return false;
		if (project != other.project)
			return false;
		return true;
	}

	public long getEmployee() {
		return employee;
	}

	public void setEmployee(long employee) {
		this.employee = employee;
	}

	public long getProject() {
		return project;
	}

	public void setProject(long project) {
		this.project = project;
	}

}
