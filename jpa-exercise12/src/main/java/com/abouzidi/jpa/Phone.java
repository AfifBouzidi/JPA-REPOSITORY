package com.abouzidi.jpa;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Phone {

	@SequenceGenerator(name = "phone_gen", sequenceName = "phone_seq")
	@Id
	@GeneratedValue(generator = "phone_gen")
	private long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	public Phone() {
	}

	public Phone(PhoneType type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PhoneType getType() {
		return type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

}

enum PhoneType {
	SAMSUNG, NOKIA
}
