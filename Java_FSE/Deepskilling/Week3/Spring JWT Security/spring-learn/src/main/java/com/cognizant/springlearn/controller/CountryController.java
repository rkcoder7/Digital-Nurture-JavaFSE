package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private CountryService countryService;

	public CountryController() {
		LOGGER.debug("Inside CountryController Constructor.");
	}

	/**
	 * REST - Country Web Service.
	 *
	 * GET /country -> loads the "country" (India) bean from country.xml and
	 * returns it.
	 */
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);

		LOGGER.info("END");
		return country;
	}

	/**
	 * REST - Get all countries.
	 *
	 * GET /countries -> loads the countryList bean from country.xml and
	 * returns it. This is the service the JWT/Spring Security hands-on
	 * secures and tests against.
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList", List.class);

		LOGGER.info("END");
		return countryList;
	}

	/**
	 * REST - Get country based on country code.
	 *
	 * GET /countries/{code} -> delegates to countryService.getCountry(code),
	 * which does a case-insensitive match against the country list loaded
	 * from country.xml.
	 */
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		LOGGER.info("START");

		Country country = countryService.getCountry(code);

		LOGGER.info("END");
		return country;
	}

}

