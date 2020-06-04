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
	
//	// Get by id
//	@GetMapping("/employee/{id}")
//	public ResponseEntity<Profile> getById(@PathVariable("id") long id){
//		return this.userService.getById(id);
//	}
//	
//	
//	// Insert for database
//	@PostMapping("/employee/create")
//	public ResponseEntity<Profile> create(@RequestBody Profile employee) {
//		return this.employeeService.create(employee);
//	}
//	
//	// Update
//	@PutMapping("/role/employee/{id}")
//	public ResponseEntity<Profile> update(@PathVariable("id") long id, @RequestBody Profile employee) {
//		return this.employeeService.update(id, employee);
//	}
//	
//	// Delete
//	@DeleteMapping("/employee/delete/{id}")
//	public ResponseEntity<String> delete(@PathVariable("id") long id) {
//		return this.employeeService.delete(id);
//	}
	
}
