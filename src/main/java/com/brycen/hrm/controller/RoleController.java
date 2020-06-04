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

import com.brycen.hrm.model.Role;
import com.brycen.hrm.service.RoleService;


@RestController
@CrossOrigin
@RequestMapping("api")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	// Get all data
	@GetMapping("/role")
	public ResponseEntity<List<Role>> getAll() {
		return this.roleService.getAll();
	}
	
	// Get by id
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getById(@PathVariable("id") long id){
		return this.roleService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/role/create")
	public ResponseEntity<Role> create(@RequestBody Role role) {
		return this.roleService.create(role);
	}
	
	// Update
	@PutMapping("/role/update/{id}")
	public ResponseEntity<Role> update(@PathVariable("id") long id, @RequestBody Role role) {
		return this.roleService.update(id, role);
	}
	
	// Delete
	@DeleteMapping("/role/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		return this.roleService.delete(id);
	}
//	
}
