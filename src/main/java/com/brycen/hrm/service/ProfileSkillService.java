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
	public ResponseEntity<List<ProfileSkill>> create(ReqProfleSkill reqProfleSkill) {
		try {
			// Foreach skill
			
			// Create list ProfileSkill
			List<ProfileSkill> listPs = new ArrayList<ProfileSkill>();
			// Get profile by id
			Optional<Profile> _profile = profileRepository.findById(reqProfleSkill.profile_id);
			
			//Create a ProfileSkill
			for(int i = 0; i < reqProfleSkill.skill_ids.size();i++  ) {
				
				// Get skill by id
				ProfileSkill ps = new ProfileSkill();
				Optional<Skill> _skills = skillRepository.findById(reqProfleSkill.skill_ids.get(i));
				Optional<LevelSkill> _levelSkills = levelSkillRepository.findById(reqProfleSkill.level_ids.get(i));
				
				ps.setSkill(_skills.get());
				ps.setLevel(_levelSkills.get());
				ps.setProfile(_profile.get());
				listPs.add(ps);
				
			}
			
			// Save all List ProfileSkill
			 return new ResponseEntity<>(profileSkillRepository.saveAll(listPs), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
   
	
//	// Update data
	public ResponseEntity<List<ProfileSkill>> update(List<Long> ids, ReqProfleSkill reqProfleSkill) {
		try {
			// Get Profile_skill by id
			List<ProfileSkill> _profileSkills = profileSkillRepository.findAllById(ids);	
			 
			 if(_profileSkills.size() != 0) {			 
				List<ProfileSkill> listPs = new ArrayList<ProfileSkill>();
			 	Optional<Profile> _profile = profileRepository.findById(reqProfleSkill.profile_id);
					for(int i = 0; i < reqProfleSkill.skill_ids.size();i++ ) {
						// Get skill by id
						Optional<Skill> _skill = skillRepository.findById(reqProfleSkill.skill_ids.get(i));
						Optional<LevelSkill> _levelSkill = levelSkillRepository.findById(reqProfleSkill.level_ids.get(i));
						ProfileSkill ps = _profileSkills.get(i);
						
						ps.setSkill(_skill.get());
						ps.setLevel(_levelSkill.get());
						ps.setProfile(_profile.get());
						listPs.add(ps);
					}
					 return new ResponseEntity<>(profileSkillRepository.saveAll(listPs), HttpStatus.OK);			 
				}else {
					 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}	

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Remove data by Id Profile
		public ResponseEntity<ResDelete> RemoveAll(Long id) {
			try {
				 Optional<Profile> _profile = profileRepository.findById(id);
				 if(_profile.isPresent()) {
					 profileSkillRepository.RemoveAll(id);		
					 return new ResponseEntity<>(new ResDelete(), HttpStatus.OK);		
				 }	 
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
}
