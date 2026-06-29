package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.DTOs.EmployeeDTO;
import com.cognizant.orm_learn.DTOs.EmployeeSkillDTO;
import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;

@SpringBootApplication
public class EmployeeApplicationTest {
	private static EmployeeService emp_ser;
	private static DepartmentService dep_ser;
	public static void main(String[] args) {
		 ApplicationContext context = SpringApplication.run(EmployeeApplicationTest.class, args);
		emp_ser =context.getBean(EmployeeService.class);
		dep_ser = context.getBean(DepartmentService.class);
	//	testAddNewEmployeeToDb();
	//	 testGetEmployeeById();
	//	testUpdateEmployeeSalary();
	//	testUpdateEmployeeDOB();
		testGetEmployeeSkillSets();
	}
	public static void testAddNewEmployeeToDb() {
		System.out.println("Test Started");
		Department dp = dep_ser.getDeptById(2);
		Employee new_comer = Employee.builder().name("Mohan Sarady")
				.salary(new BigDecimal("102000.00")).department(dp).build();
		emp_ser.saveEmployee(new_comer);
		System.out.println("Employee Added");
	}
	public static void testGetEmployeeById() {
		System.out.println("Test Started");
		EmployeeDTO test_emp = emp_ser.getEmployeeById(41);
		System.out.println("Employee Details : ");
		System.out.println(test_emp);
		// System.out.println("Department : " + test_emp.getDepartment());
	}
	public static void testUpdateEmployeeSalary() {
		System.out.println("Test Started");
		BigDecimal sal_updt = new BigDecimal(130000.00);
		emp_ser.updateEmployeeSalary(41, sal_updt);
	}
	public static void testUpdateEmployeeDOB() {
		System.out.println("Test Started");
		java.sql.Date dob = java.sql.Date.valueOf("2005-11-24");
		emp_ser.updateEmployeeDOB(41, dob);
	}
	public static void testGetEmployeeSkillSets() {
		System.out.println("Test Started");
		EmployeeSkillDTO em_skills = emp_ser.getEmployeeSkills(5);
		System.out.println(em_skills);
		System.out.println("Test Ended");
	}
}
