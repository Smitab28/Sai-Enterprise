package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbk.entity.Country;
import com.jbk.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {


	@Autowired
	CountryService countryService;
	
	@PostMapping("/add-country")
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		String msg = countryService.addCountry(country);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("/update-country/{countryId}")
	public ResponseEntity<String> updateCountry(@RequestBody Country country) {
		String msg = countryService.updateCountry(country);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/delete-country-by-id/{countryId}")
	public ResponseEntity<String> deleteCountryById(@PathVariable long countryId) {
		String msg = countryService.deleteCountryById(countryId);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/get-country-by-id/{countryId}")
	public ResponseEntity< Country> getCountryByID(@PathVariable long countryId) {
		Country country = countryService.getCountryByID(countryId);
		return ResponseEntity.ok(country);
	}

	@DeleteMapping("/delete-country-by-name/{countryName}")
	public ResponseEntity<String> deleteCountryByName(@PathVariable String countryName) {
		String msg = countryService.deleteCountryByName(countryName);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/get-all-country")
	public ResponseEntity<List<Country>> getAllcountry() {
		List<Country> countryList = countryService.getAllcountry();
		return ResponseEntity.ok(countryList);
	}
}
