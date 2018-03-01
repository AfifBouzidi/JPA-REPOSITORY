package com.abouzidi.jpa;

import javax.persistence.Entity;

@Entity
public class QualityProject extends Project{
	
	private String qualityCode;

	public String getQualityCode() {
		return qualityCode;
	}

	public void setQualityCode(String qualityCode) {
		this.qualityCode = qualityCode;
	}

	
}
