package com.abouzidi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Project {

	@SequenceGenerator(name="prj_gen",sequenceName="prj_seq")
	@Id
	@GeneratedValue(generator="prj_gen")
	private long id;

	private String name;

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
}
