package com.cognizant.springlearn;

import java.util.List;

/**
 * Employee - simple POJO representing an employee, matching the employee
 * data shown on the Angular employee-list screen (id, name, gender,
 * department and skills).
 */
public class Employee {

	private int id;
	private String name;
	private String gender;
	private Department department;
	private List<Skill> skills;

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department
				+ ", skills=" + skills + "]";
	}

}
