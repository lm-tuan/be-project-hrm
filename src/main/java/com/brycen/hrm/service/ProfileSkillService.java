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
import com.brycen.hrm.model.LevelSkill;
import com.brycen.hrm.model.Profile;
import com.brycen.hrm.model.ProfileSkill;
import com.brycen.hrm.model.Role;
import com.brycen.hrm.model.Skill;
import com.brycen.hrm.model.User;
import com.brycen.hrm.model.request.ReqProfleSkill;
import com.brycen.hrm.model.response.ResDelete;
import com.brycen.hrm.repository.LevelSkillRepository;
import com.brycen.hrm.repository.ProfileRepository;
import com.brycen.hrm.repository.ProfileSkillRepository;
import com.brycen.hrm.repository.SkillRepository;
import com.brycen.hrm.repository.UserRepositoty;


@Service
public class ProfileSkillService {
	@Autowired
	ProfileSkillRepository profileSkillRepository;
	
	@Autowired
	SkillRepository skillRepository;
	
	@Autowired
	LevelSkillRepository levelSkillRepository;
	
	@Autowired
	ProfileRepository profileRepository;
	
	
	// Insert data
	public ResponseEntity<ProfileSkill> create(ReqProfleSkill reqProfleSkill) {
		try {
			// user.setDeleteFlag(0);
			 Optional<Skill> _skill = skillRepository.findById(reqProfleSkill.skill_id);		
			 Optional<LevelSkill> _levelSkill = levelSkillRepository.findById(reqProfleSkill.level_id);
			 Optional<Profile> _profile = profileRepository.findById(reqProfleSkill.profile_id);
			 
			 ProfileSkill ps = new ProfileSkill();
			 ps.setSkill(_skill.get());
			 ps.setLevel(_levelSkill.get());
			 ps.setProfile(_profile.get());
			 return new ResponseEntity<>(profileSkillRepository.save(ps), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	
	// Update data
	public ResponseEntity<ProfileSkill> update(Long id, ReqProfleSkill reqProfleSkill) {
		try {
			// Get Profile_skill by id
			 Optional<ProfileSkill> _profileSkill = profileSkillRepository.findById(id);	
			 
			 if(_profileSkill.isPresent()) {
				 Optional<Skill> _skill = skillRepository.findById(reqProfleSkill.skill_id);		
				 Optional<LevelSkill> _levelSkill = levelSkillRepository.findById(reqProfleSkill.level_id);
				 Optional<Profile> _profile = profileRepository.findById(reqProfleSkill.profile_id);
				 
				 ProfileSkill ps = _profileSkill.get();
				 
				 ps.setSkill(_skill.get());
				 ps.setLevel(_levelSkill.get());
				 ps.setProfile(_profile.get());	
				 
				return new ResponseEntity<>(profileSkillRepository.save(ps), HttpStatus.OK);
				}else {
					 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
