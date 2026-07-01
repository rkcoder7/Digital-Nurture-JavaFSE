package com.cognizant.springlearn;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

	@SuppressWarnings("unchecked")
	private static ArrayList<Department> DEPARTMENT_LIST;

	public DepartmentDao() {
		LOGGER.debug("Inside DepartmentDao Constructor - loading employee.xml");

		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", ArrayList.class);
	}

	public ArrayList<Department> getAllDepartments() {
		LOGGER.debug("Inside DepartmentDao.getAllDepartments() - returning {} departments", DEPARTMENT_LIST.size());
		return DEPARTMENT_LIST;
	}

}
