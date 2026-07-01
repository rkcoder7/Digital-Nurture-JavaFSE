package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country - simple POJO representing a country with a two-character ISO
 * code and a name. Instances of this class are configured and created
 * by the Spring IoC container using the bean definition found in
 * country.xml (src/main/resources/country.xml).
 */
public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	}

	public String getCode() {
		LOGGER.debug("Inside getCode() - code : {}", code);
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside setCode() - code : {}", code);
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside getName() - name : {}", name);
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside setName() - name : {}", name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
