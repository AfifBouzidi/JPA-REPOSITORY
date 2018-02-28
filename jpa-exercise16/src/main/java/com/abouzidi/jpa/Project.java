package com.abouzidi.jpa;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Project {

	@SequenceGenerator(name="prj_gen",sequenceName="prj_seq")
	@Id
	@GeneratedValue(generator="prj_gen")
	private long id;

	private String name;

	public Project() {
	}
	
	public Project(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="project")
	private Collection<ProjectAssignment> assignments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<ProjectAssignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Collection<ProjectAssignment> assignments) {
		this.assignments = assignments;
	}

}
