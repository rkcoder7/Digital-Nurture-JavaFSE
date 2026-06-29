package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.DTOs.SkillDTO;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.service.SkillService;

@SpringBootApplication
public class SkillServiceTest {
	
	private static SkillService sk_ser;
	private static Skill sk;
	public static void main(String[] args) {
		
	 ApplicationContext context = SpringApplication.run(SkillServiceTest.class, args);
	 sk_ser = context.getBean(SkillService.class);
	 
	// testSaveSkillMethod();
	 testGetSkillById();
	 
	}
	
	public static void testSaveSkillMethod() {
		sk = Skill.builder().name("Java FSE").build();
		System.out.println("Test Started");
		sk_ser.saveSkill(sk);
		System.out.println("test ended");
		sk=null;
	}
	public static void testGetSkillById() {
		System.out.println("Test Started");
		SkillDTO sk_dto = sk_ser.getSkillById(31);
		System.out.println(sk_dto);
		System.out.println("Test Ended");
	}
}
