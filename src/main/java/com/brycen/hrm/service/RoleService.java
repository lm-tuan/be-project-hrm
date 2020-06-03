package com.brycen.hrm.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brycen.hrm.model.Role;
import com.brycen.hrm.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	// Get all
	public ResponseEntity<List<Role>> getAll() {
		try {
			List<Role> roles = new ArrayList<Role>();
//			roles = roleRepository.findAll();
			roles = roleRepository.findAllByFlag();
			return new ResponseEntity<>(roles, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
	public ResponseEntity<Role> getById(Long id) {
		try {
			 Optional<Role> roleData = roleRepository.findByIdAndFlag(id);
			if(roleData.isPresent()) {
				return new ResponseEntity<>(roleData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<Role> create(Role role) {
		try {
			role.setDelete_flag(0);
			Role _role = roleRepository.save(role);
			
			 return new ResponseEntity<>(_role, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	
	public ResponseEntity<Role> update(Long id, Role role) {
		try {
			Optional<Role> roleData = roleRepository.findByIdAndFlag(id);
			if(roleData.isPresent()) {
				Role _role = roleData.get();
				_role.setName(role.getName());
				return new ResponseEntity<>(roleRepository.save(_role), HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<String> delete(Long id) {
		try {
			Optional<Role> roleData = roleRepository.findByIdAndFlag(id);
			if(roleData.isPresent()) {
				Role _role = roleData.get();
				_role.setDelete_flag(1);
				return new ResponseEntity<>("Delete user action success ", HttpStatus.OK);
			}else {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
