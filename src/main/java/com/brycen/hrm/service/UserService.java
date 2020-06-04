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
	public ResponseEntity<User> getById(Long id) {
		try {
			 Optional<User> userData = userRepositoty.findByIdAndFlag(id);
			if(userData.isPresent()) {
				return new ResponseEntity<>(userData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<User> create(User user) {
		try {
			user.setDeleteFlag(0);
			User _user = userRepositoty.save(user);
			
			 return new ResponseEntity<>(_user, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	public ResponseEntity<User> update(Long id, User user) {
		try {
			// Get user by id
			Optional<User> userData = userRepositoty.findByIdAndFlag(id);
			// Check user exist
			if(userData.isPresent()) {
				User u = userData.get();
				u.setDeleteFlag(0);
				u.setUserName(user.getUserName());
				u.setPassWord(user.getPassWord());
				return new ResponseEntity<>(userRepositoty.save(u), HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Delete
	public ResponseEntity<String> delete(Long id) {
		try {
			Optional<User> userData = userRepositoty.findByIdAndFlag(id);
			if(userData.isPresent()) {
				User u = userData.get();
				u.setDeleteFlag(1);
				try {
					userRepositoty.save(u);
					return new ResponseEntity<>("Delete employee action success ", HttpStatus.OK);
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
