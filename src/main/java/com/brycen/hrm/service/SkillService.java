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
import com.brycen.hrm.model.Skill;
import com.brycen.hrm.model.User;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.repository.SkillRepository;
import com.brycen.hrm.repository.UserRepositoty;


@Service
public class SkillService {
	@Autowired
	SkillRepository skillRepository;
	
	// Get all
	public ResponseEntity<List<Skill>> getAll() {
		try {
			List<Skill> skills = new ArrayList<Skill>();
			skills = skillRepository.findAllByFlag();
			return new ResponseEntity<>(skills, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Get by Id
	public ResponseEntity<Skill> getById(Long id) {
		try {
			 Optional<Skill> skillData = skillRepository.findByIdAndFlag(id);
			if(skillData.isPresent()) {
				return new ResponseEntity<>(skillData.get(), HttpStatus.OK);
			}else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<Skill> create(Skill skill) {
		try {
			// user.setDeleteFlag(0);
			Skill _skill = skillRepository.save(skill);
			
			 return new ResponseEntity<>(_skill, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Insert data
	public ResponseEntity<List<Skill>> saveAll(List<Skill> skills) {
		try {
			// user.setDeleteFlag(0);
			List<Skill> _skills = skillRepository.saveAll(skills);
			 return new ResponseEntity<>(_skills, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	// Update data
	public ResponseEntity<Skill> update(Long id, Skill skill) {
		try {
			// Get user by id
			Optional<Skill> skillData = skillRepository.findByIdAndFlag(id);
			// Check user exist
			if(skillData.isPresent()) {
				Skill s = skillData.get();
				s.setDelete_flag(DeleteFlag.NO.getNumVal());
				s.setName(skill.getName());
				return new ResponseEntity<>(skillRepository.save(s), HttpStatus.OK);
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
			Optional<Skill> skillData = skillRepository.findByIdAndFlag(id);
			if(skillData.isPresent()) {
				Skill s = skillData.get();
				s.setDelete_flag(DeleteFlag.YES.getNumVal());
				try {
					skillRepository.save(s);
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
