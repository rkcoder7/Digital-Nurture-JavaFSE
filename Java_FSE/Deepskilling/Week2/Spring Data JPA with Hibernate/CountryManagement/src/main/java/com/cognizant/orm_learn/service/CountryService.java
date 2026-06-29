package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.Exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;



@Service
public class CountryService {
	
	@Autowired
	private CountryRepository c_repo;
	
	@Transactional
	public void addCountry(Country co) {
		c_repo.save(co);
	}
	
	@Transactional
	public List<Country> getAllCountries(){
		return c_repo.findAll();
	}
	@Transactional
	public Country findCountryByCode(String co_code) {
		Optional<Country> res = c_repo.findById(co_code);
		if(res.get() == null) {
			throw new CountryNotFoundException("Country Not Found - Kindly enter proper country code");
		}
		return res.get();
	}
	
	@Transactional
	public void updateCountryByCode(String co_code, Country co) {
		Optional<Country> res = c_repo.findById(co_code);
		if(res.get() == null) {
			throw new CountryNotFoundException("Country Not Found - Kindly enter proper country code");
		}
		c_repo.save(co);
	}
	@Transactional
	public void  deleteCountryByCode(String co_code) {
		Optional<Country> res = c_repo.findById(co_code);
		if(res.get()== null) {
			throw new CountryNotFoundException("Country Not Found - Kindly enter proper country code");
		}
		c_repo.deleteById(co_code);
	}
	
	@Transactional
	public List<Country> findCountryBySearching(String partial_name){
		return c_repo.findByNameContainingIgnoreCase(partial_name);
	}
}
