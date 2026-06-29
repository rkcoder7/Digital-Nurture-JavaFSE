
package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository dep_repo;
	
	@Transactional
	public Department getDeptById(int id) {
		return dep_repo.findById(id).get();
	}
}
