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
import com.brycen.hrm.service.EmployeeService;


@RestController
@CrossOrigin
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	// Get all data
	@GetMapping("/employee")
	public ResponseEntity<List<Profile>> getAll() {
		return this.employeeService.getAll();
	}
	
	// Get by id
	@GetMapping("/employee/{id}")
	public ResponseEntity<Profile> getById(@PathVariable("id") long id){
		return this.employeeService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/employee/create")
	public ResponseEntity<Profile> create(@RequestBody Profile employee) {
		return this.employeeService.create(employee);
	}
	
	// Update
	@PutMapping("/role/employee/{id}")
	public ResponseEntity<Profile> update(@PathVariable("id") long id, @RequestBody Profile employee) {
		return this.employeeService.update(id, employee);
	}
	
	// Delete
	@DeleteMapping("/employee/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		return this.employeeService.delete(id);
	}
	
}
