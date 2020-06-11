package com.brycen.hrm.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brycen.hrm.common.DeleteFlag;
import com.brycen.hrm.model.LevelSkill;
import com.brycen.hrm.model.Skill;

import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.repository.LevelSkillRepository;
import com.brycen.hrm.repository.SkillRepository;



@Service
public class LevelSkillService {
	@Autowired
	LevelSkillRepository levelSkillRepository;
	
	// Get all
	public ResponseEntity<List<LevelSkill>> getAll() {
		try {
			List<LevelSkill> levelSkills = new ArrayList<LevelSkill>();
			levelSkills = levelSkillRepository.findAll();
			return new ResponseEntity<>(levelSkills, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
