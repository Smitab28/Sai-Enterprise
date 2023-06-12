package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long countryId;
	@Column(unique = true)
	@NotEmpty(message="Country name should not be empty")
	private String countryName;
	
	public Country() {}

	public Country(long countryId, @NotEmpty(message = "Country name should not be empty") String countryName) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
	
}
