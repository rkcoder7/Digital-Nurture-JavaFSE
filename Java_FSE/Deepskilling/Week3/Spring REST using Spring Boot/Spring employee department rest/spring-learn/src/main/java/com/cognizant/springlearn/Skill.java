package com.cognizant.springlearn;

/**
 * Skill - simple POJO representing a skill (e.g. Java, Spring, Angular).
 * Skill beans are defined once in employee.xml and reused (via <ref>) by
 * multiple Employee beans instead of being re-created for each employee.
 */
public class Skill {

	private int id;
	private String name;

	public Skill() {
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
		return "Skill [id=" + id + ", name=" + name + "]";
	}

}
