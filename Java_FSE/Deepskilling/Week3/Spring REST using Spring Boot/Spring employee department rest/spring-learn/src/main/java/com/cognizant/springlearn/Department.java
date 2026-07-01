package com.cognizant.springlearn;

/**
 * Department - simple POJO representing a department (e.g. Engineering, HR).
 * Department beans are defined in employee.xml and referenced by Employee
 * beans, and are also collected into a departmentList bean for the
 * Department REST service.
 */
public class Department {

	private int id;
	private String name;

	public Department() {
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
