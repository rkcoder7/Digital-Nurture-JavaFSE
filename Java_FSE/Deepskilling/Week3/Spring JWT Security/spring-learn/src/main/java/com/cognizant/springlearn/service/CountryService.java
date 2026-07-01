package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	/**
	 * Loads the country list from country.xml and returns the country whose
	 * code matches the given code, ignoring case. Uses a lambda expression
	 * (Stream.filter) instead of a manual for-loop.
	 */
	@SuppressWarnings("unchecked")
	public Country getCountry(String code) {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList = (List<Country>) context.getBean("countryList", List.class);

		Country match = countryList.stream()
				.filter(country -> country.getCode().equalsIgnoreCase(code))
				.findFirst()
				.orElse(null);

		LOGGER.debug("getCountry({}) -> {}", code, match);
		LOGGER.info("END");
		return match;
	}

}
