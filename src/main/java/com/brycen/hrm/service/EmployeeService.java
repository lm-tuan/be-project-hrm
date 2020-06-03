package com.brycen.hrm.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Profile;
import com.brycen.hrm.model.Role;
import com.brycen.hrm.repository.UserRepositoty;


@Service
public class EmployeeService {
	@Autowired
	UserRepositoty employeeRepository;
	
	// Get all
	public ResponseEntity<List<Profile>> getAll() {
		try {
			List<Profile> employees = new ArrayList<Profile>();
			employees = employeeRepository.findAllByFlag();
			return new ResponseEntity<>(employees, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
	public ResponseEntity<Profile> getById(Long id) {
		try {
			 Optional<Profile> employeeData = employeeRepository.findByIdAndFlag(id);
			if(employeeData.isPresent()) {
				return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<Profile> create(Profile employee) {
		try {
			employee.setDelete_flag(0);
			Profile _employee = employeeRepository.save(employee);
			
			 return new ResponseEntity<>(_employee, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	
	public ResponseEntity<Profile> update(Long id, Profile employee) {
		try {
			Optional<Profile> employeeData = employeeRepository.findByIdAndFlag(id);
			if(employeeData.isPresent()) {
				Profile _employee = employeeData.get();
				_employee.setBirthday(employee.getBirthday());
				_employee.setFull_name(employee.getEmail());
				_employee.setEmail(employee.getEmail());
				_employee.setPhone(employee.getPhone());
				_employee.setPosition(employee.getPosition());
				_employee.setGender(employee.isGender());
				_employee.setDelete_flag(0);
				
				return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<String> delete(Long id) {
		try {
			Optional<Profile> employeeData = employeeRepository.findByIdAndFlag(id);
			if(employeeData.isPresent()) {
				Profile _employee = employeeData.get();
				_employee.setDelete_flag(1);
				return new ResponseEntity<>("Delete employee action success ", HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
