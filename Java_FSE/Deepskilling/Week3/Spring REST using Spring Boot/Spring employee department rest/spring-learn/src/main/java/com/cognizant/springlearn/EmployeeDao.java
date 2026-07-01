package com.cognizant.springlearn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	@SuppressWarnings("unchecked")
	private static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		LOGGER.debug("Inside EmployeeDao Constructor - loading employee.xml");

		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", ArrayList.class);
	}

	public ArrayList<Employee> getAllEmployees() {
		LOGGER.debug("Inside EmployeeDao.getAllEmployees() - returning {} employees", EMPLOYEE_LIST.size());
		return EMPLOYEE_LIST;
	}

}
