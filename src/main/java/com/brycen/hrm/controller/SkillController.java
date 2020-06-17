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

import com.brycen.hrm.model.Skill;
import com.brycen.hrm.model.User;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.service.SkillService;
import com.brycen.hrm.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	// Get all data
	@GetMapping("/skill")
	public ResponseEntity<List<Skill>> getAll() {
		return this.skillService.getAll();
	}
	
	// Get by id
	@GetMapping("/skill/{id}")
	public ResponseEntity<Skill> getById(@PathVariable("id") long id){
		return this.skillService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/skill/create")
	public ResponseEntity<Skill> create(@RequestBody Skill skill) {
		return this.skillService.create(skill);
	}
	
	// Insert many for database
	@PostMapping("/skill/createAll")
	public ResponseEntity<List<Skill>> createAll(@RequestBody List<Skill> skills) {
		return this.skillService.saveAll(skills);
	}
		
	
	// Update
	@PutMapping("/skill/update/{id}")
	public ResponseEntity<Skill> update(@PathVariable("id") long id, @RequestBody Skill skill) {
		return this.skillService.update(id, skill);
	}
	
	// Delete
	@DeleteMapping("/skill/delete/{id}")
	public ResponseEntity<ResDelete> delete(@PathVariable("id") long id) {
		return this.skillService.delete(id);
	}
}
