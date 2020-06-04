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

import com.brycen.hrm.model.User;
import com.brycen.hrm.service.UserService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// Get all data
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAll() {
		return this.userService.getAll();
	}
	
	// Get by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getById(@PathVariable("id") long id){
		return this.userService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/user/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		return this.userService.create(user);
	}
	
	// Update
	@PutMapping("/user/update/{id}")
	public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user) {
		return this.userService.update(id, user);
	}
	
	// Delete
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		return this.userService.delete(id);
	}
	
}
