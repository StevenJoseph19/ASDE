package com.mycompany.hibernatefundamentals.airport;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "PASSENGER_STREET")),
		@AttributeOverride(name = "number", column = @Column(name = "PASSENGER_NUMBER")),
		@AttributeOverride(name = "zipCode", column = @Column(name = "PASSENGER_ZIP_CODE")),
		@AttributeOverride(name = "city", column = @Column(name = "PASSENGER_CITY")),
		
	})
	private Address address;
	

	public Passenger(String name) {
		
		this.name = name;
		
	}

	public Passenger() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
