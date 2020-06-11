package com.brycen.hrm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brycen.hrm.model.LevelSkill;
import com.brycen.hrm.model.Skill;
import com.brycen.hrm.model.User;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.service.LevelSkillService;
import com.brycen.hrm.service.SkillService;
import com.brycen.hrm.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LevelSkillController {
	
	@Autowired
	LevelSkillService levelSkillService;
	
	// Get all data
	@GetMapping("/level-skill")
	public ResponseEntity<List<LevelSkill>> getAll() {
		return this.levelSkillService.getAll();
	}
	
}
