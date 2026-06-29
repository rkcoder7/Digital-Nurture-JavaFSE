package com.cognizant.orm_learn.DTOs;

import java.util.List;
import java.util.Set;

import com.cognizant.orm_learn.model.Skill;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSkillDTO {
	private int id;
	private String emp_name;
	private String deptName;
	private List<Skill> emp_skills;
}
