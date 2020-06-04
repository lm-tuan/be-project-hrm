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
import com.brycen.hrm.model.User;
import com.brycen.hrm.repository.UserRepositoty;


@Service
public class UserService {
	@Autowired
	UserRepositoty userRepositoty;
	
	// Get all
	public ResponseEntity<List<User>> getAll() {
		try {
			List<User> users = new ArrayList<User>();
			users = userRepositoty.findAll();
			return new ResponseEntity<>(users, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
//	public ResponseEntity<User> getById(Long id) {
//		try {
//			 Optional<User> userData = userRepositoty.findByIdAndFlag(id);
//			if(userData.isPresent()) {
//				return new ResponseEntity<>(userData.get(), HttpStatus.OK);
//			}else {
//			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		    }
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	// Insert data
//	public ResponseEntity<User> create(User user) {
//		try {
//			user.setDelete_flag(0);
//			User _user = userRepositoty.save(user);
//			
//			 return new ResponseEntity<>(_user, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
   
	// Update data
	
//	public ResponseEntity<User> update(Long id, User user) {
//		try {
//			Optional<User> userData = userRepositoty.findByIdAndFlag(id);
//			if(userData.isPresent()) {
//				_employee.setDelete_flag(0);
//				
//				return new ResponseEntity<>(userRepositoty.save(_employee), HttpStatus.OK);
//			}else {
//				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}			
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	public ResponseEntity<String> delete(Long id) {
//		try {
//			Optional<Profile> employeeData = userRepositoty.findByIdAndFlag(id);
//			if(employeeData.isPresent()) {
//				Profile _employee = employeeData.get();
//				_employee.setDelete_flag(1);
//				return new ResponseEntity<>("Delete employee action success ", HttpStatus.OK);
//			}else {
//				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}			
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
}
