package com.jbk.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CountryDao;
import com.jbk.entity.Country;
import com.jbk.service.CountryService;


@Service
public class CountryServiceIMPL implements CountryService {

	@Autowired
	CountryDao countryDao;
	
	@Override
	public String addCountry(Country country) {
		String msg = countryDao.addCountry(country);
		return msg;
	}

	@Override
	public String updateCountry(Country country) {
		String msg = countryDao.updateCountry(country);
		return msg;
	}

	@Override
	public String deleteCountryById(long countryId) {
		String msg = countryDao.deleteCountryById(countryId);
		return msg;
	}

	@Override
	public Country getCountryByID(long countryId) {
		Country country = countryDao.getCountryByID(countryId);
		return country;
	}

	@Override
	public String deleteCountryByName(String countryName) {
		String msg = countryDao.deleteCountryByName(countryName);
		return msg;
	}

	@Override
	public List<Country> getAllcountry() {
		List<Country> countryList = countryDao.getAllcountry();
		return countryList;
	}

}
