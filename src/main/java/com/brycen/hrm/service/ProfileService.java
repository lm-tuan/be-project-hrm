package com.brycen.hrm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brycen.hrm.common.DeleteFlag;
import com.brycen.hrm.model.Profile;
import com.brycen.hrm.model.response.*;
import com.brycen.hrm.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	
	// Get all
	public ResponseEntity<List<Profile>> getAll() {
		try {
			List<Profile> profile = new ArrayList<Profile>();
			profile = profileRepository.findAllByFlag();
			return new ResponseEntity<>(profile, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
	public ResponseEntity<Profile> getById(Long id) {
		try {
			 Optional<Profile>profileData = profileRepository.findByIdAndFlag(id);
			if(profileData.isPresent()) {
				return new ResponseEntity<>(profileData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<Profile> create(Profile profile) {
		try {
			profile.setDelete_flag(DeleteFlag.NO.getNumVal());
			Profile p = profileRepository.save(profile);
			
			 return new ResponseEntity<>(p, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	public ResponseEntity<Profile> update(Long id, Profile profile) {
		try {
			// Get user by id
			Optional<Profile> profileData = profileRepository.findByIdAndFlag(id);
			// Check user exist
			if(profileData.isPresent()) {
				Profile p = profileData.get();
				// Update field
				p.setBirthday(profile.getBirthday());
				p.setDelete_flag((profile.getDelete_flag()));
				p.setEmail(profile.getEmail());
				p.setFullName(profile.getFullName());
				p.setGender(profile.getGender());
				p.setIdCard(profile.getIdCard());
				p.setPhone(profile.getPhone());
				p.setPosition(profile.getPosition());
				p.setUpdate_date(new Date());
				profileRepository.save(p);
				return new ResponseEntity<>(p, HttpStatus.OK);
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
 			Optional<Profile> profileData = profileRepository.findByIdAndFlag(id);
			if(profileData.isPresent()) {
				Profile p = profileData.get();
				p.setDelete_flag(DeleteFlag.NO.getNumVal());
				try {
					profileRepository.save(p);
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
