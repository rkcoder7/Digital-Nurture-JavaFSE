package com.cognizant.orm_learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.DTOs.SkillDTO;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.repository.SkillRepository;

import jakarta.transaction.Transactional;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository sk_repo;

	@Transactional
	public Skill saveSkill(Skill sk) {
		return sk_repo.save(sk);
	}
	
	@Transactional
	public SkillDTO getSkillById(int id) {
		Skill cur_obj = sk_repo.findById(id).get();
		SkillDTO ret_obj = SkillDTO.builder().id(cur_obj.getId()).name(cur_obj.getName()).build();
		return ret_obj;
	}
}
