package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/departments")
	public Department[] getAllDepartments() {
		LOGGER.info("START - GET /departments called");

		Department[] departments = departmentService.getAllDepartments().toArray(new Department[0]);

		LOGGER.info("END - returning {} departments", departments.length);
		return departments;
	}

}
