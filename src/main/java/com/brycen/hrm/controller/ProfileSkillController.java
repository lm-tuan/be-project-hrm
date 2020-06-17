package com.brycen.hrm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.brycen.hrm.model.ProfileSkill;
import com.brycen.hrm.model.request.ReqProfleSkill;
import com.brycen.hrm.service.ProfileSkillService;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProfileSkillController {
	
	@Autowired
	ProfileSkillService profileSkillService;
	
	
	
	
	// Insert for database
	@PostMapping("/profile-skill/create")
	public ResponseEntity<ProfileSkill> create(@RequestBody  ReqProfleSkill reqProfleSkill) {
		return this.profileSkillService.create(reqProfleSkill);
	}
	
	 // Update
	@PutMapping("/profile-skill/update/{id}")
	public ResponseEntity<ProfileSkill> update(@PathVariable("id") long id, @RequestBody ReqProfleSkill reqProfleSkill) {
		return this.profileSkillService.update(id, reqProfleSkill);
	}
	
	
}
