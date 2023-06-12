package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Country;

public interface CountryDao {

	public String addCountry(Country country);
	public String updateCountry(Country country);
	public String deleteCountryById(long countryId);
	public Country getCountryByID(long countryId);
	public String deleteCountryByName(String countryName);
	public List<Country> getAllcountry();
	
}
