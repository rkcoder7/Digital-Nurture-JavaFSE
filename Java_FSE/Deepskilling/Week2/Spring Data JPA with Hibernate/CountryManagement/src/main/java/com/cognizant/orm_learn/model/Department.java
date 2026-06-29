package com.cognizant.orm_learn.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		@Column(name = "dp_id")
		private int id;
		@Column(name = "dp_name")
		private String name;
		
		@OneToMany(mappedBy = "department")
		private List<Employee> employees;
}
