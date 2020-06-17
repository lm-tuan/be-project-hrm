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

import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.service.DepartmentService;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	// Get all data
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getAll() {
		return this.departmentService.getAll();
	}
	
	// Get by id
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getById(@PathVariable("id") long id){
		return this.departmentService.getById(id);
	}
	
	
	// Insert for database
	@PostMapping("/department/create")
	public ResponseEntity<Department> create(@RequestBody Department department) {
		return this.departmentService.create(department);
	}
	
	// Update
	@PutMapping("/department/update/{id}")
	public ResponseEntity<Department> update(@PathVariable("id") long id, @RequestBody Department department) {
		return this.departmentService.update(id, department);
	}
	
	// Delete
	@DeleteMapping("/department/delete/{id}")
	public ResponseEntity<ResDelete> delete(@PathVariable("id") long id) {
		return this.departmentService.delete(id);
	}
}
