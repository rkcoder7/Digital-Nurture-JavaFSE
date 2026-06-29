package com.cognizant.orm_learn.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.DTOs.EmployeeDTO;
import com.cognizant.orm_learn.DTOs.EmployeeSkillDTO;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emp_repo;
	
	Employee cur_emp;
	
	@Transactional
	public Employee saveEmployee(Employee emp) {
		return emp_repo.save(emp);
	}
	@Transactional
	public EmployeeDTO getEmployeeById(int e_id) {
		Employee emp = emp_repo.findById(e_id).get();
		EmployeeDTO res = EmployeeDTO.builder()
				.id(emp.getId())
				.name(emp.getName())
				.salary(emp.getSalary())
				.dob(emp.getDateOfBirth())
				.departmentName(emp.getDepartment().getName())
				.build();
		return res;
	}
	@Transactional
	public Employee updateEmployeeSalary(int e_id, BigDecimal updated_salary) {
		Employee cur_emp = emp_repo.findById(e_id).get(); 

		if(cur_emp != null) {
			cur_emp.setSalary(updated_salary);
			return emp_repo.save(cur_emp);
		}
		return null;	
	}
	@Transactional
	public Employee updateEmployeeDOB(int e_id, java.sql.Date updated_dob) {
		cur_emp = emp_repo.findById(e_id).get();

		if(cur_emp != null) {
			cur_emp.setDateOfBirth(updated_dob);
			return emp_repo.save(cur_emp);
		}
		return null;	
	}
	@Transactional 
	public EmployeeSkillDTO getEmployeeSkills(int e_id){ 
	    cur_emp = emp_repo.findById(e_id).get(); 
	    EmployeeSkillDTO emp_skills = EmployeeSkillDTO.builder()
	        .id(cur_emp.getId()) 
	        .emp_name(cur_emp.getName()) 
	        .deptName(cur_emp.getDepartment().getName()) 
	        .emp_skills(cur_emp.getSkillList())
	        .build(); 
	    return emp_skills; 
	}

	/*
	 * @Transactional public EmployeeSkillDTO getEmployeeSkills(int e_id){
	 * 
	 * cur_emp = emp_repo.findById(e_id).get();
	 * 
	 * System.out.println(cur_emp.getName()); // Test 1
	 * 
	 * System.out.println("Before skills");
	 * 
	 * System.out.println(cur_emp.getSkillList()); // Test 2
	 * 
	 * System.out.println("After skills");
	 * 
	 * return null; }
	 */
}
