package com.cognizant.orm_learn.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Skill {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		@Column(name = "sk_id")
		
		private int id;
		@Column(name = "sk_name")
		private String name;
		
		@ToString.Exclude
	    @ManyToMany(mappedBy = "skillList")
	    private List<Employee> employeeList;

}
