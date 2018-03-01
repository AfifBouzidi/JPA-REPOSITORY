package com.abouzidi.jpa;

import javax.persistence.Entity;

@Entity
public class DesignProject extends Project{

	private String designCode;

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}
	
	
}
