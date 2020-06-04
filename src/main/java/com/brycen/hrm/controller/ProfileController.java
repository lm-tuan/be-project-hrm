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

import com.brycen.hrm.model.Profile;
import com.brycen.hrm.service.ProfileService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProfileController {
	
	@Autowired
	ProfileService profileService;
	
	// Get all data
	@GetMapping("/profile")
	public ResponseEntity<List<Profile>> getAll() {
		return this.profileService.getAll();
	}
	
	// Get by id
	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getById(@PathVariable("id") long id){
		return this.profileService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/profile/create")
	public ResponseEntity<Profile> create(@RequestBody Profile profile) {
		return this.profileService.create(profile);
	}
	
	// Update
	@PutMapping("/profile/update/{id}")
	public ResponseEntity<Profile> update(@PathVariable("id") long id, @RequestBody Profile profile) {
		return this.profileService.update(id, profile);
	}
	
	// Delete
	@DeleteMapping("/profile/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		return this.profileService.delete(id);
	}
}
