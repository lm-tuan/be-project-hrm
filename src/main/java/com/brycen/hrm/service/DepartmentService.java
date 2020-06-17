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
import com.brycen.hrm.model.Department;
import com.brycen.hrm.model.Skill;
import com.brycen.hrm.model.User;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.repository.DepartmentRepository;
import com.brycen.hrm.repository.SkillRepository;
import com.brycen.hrm.repository.UserRepositoty;


@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	// Get all
	public ResponseEntity<List<Department>> getAll() {
		try {
			List<Department> departments = new ArrayList<Department>();
			departments = departmentRepository.findAllByFlag();
			return new ResponseEntity<>(departments, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
	public ResponseEntity<Department> getById(Long id) {
		try {
			 Optional<Department>departmentlData = departmentRepository.findByIdAndFlag(id);
			if(departmentlData.isPresent()) {
				return new ResponseEntity<>(departmentlData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<Department> create(Department department) {
		try {
			// user.setDeleteFlag(0);
			Department _department = departmentRepository.save(department);
			
			 return new ResponseEntity<>(_department, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	public ResponseEntity<Department> update(Long id, Department department) {
		try {
			// Get user by id
			Optional<Department> departmentData = departmentRepository.findByIdAndFlag(id);
			// Check user exist
			if(departmentData.isPresent()) {
				Department d = departmentData.get();
				d.setDelete_flag(DeleteFlag.NO.getNumVal());
				d.setName(department.getName());
				return new ResponseEntity<>(departmentRepository.save(d), HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete
	public ResponseEntity<ResDelete> delete(Long id) {
		try {
			Optional<Department> departmentData = departmentRepository.findByIdAndFlag(id);
			if(departmentData.isPresent()) {
				Department d = departmentData.get();
				d.setDelete_flag(DeleteFlag.YES.getNumVal());
				try {
					departmentRepository.save(d);
					return new ResponseEntity<>(new ResDelete(), HttpStatus.OK);
				} catch (Exception e) {
					return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				}	
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
