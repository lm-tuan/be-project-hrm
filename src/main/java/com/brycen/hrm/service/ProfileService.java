package com.brycen.hrm.service;

import java.text.SimpleDateFormat;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.brycen.hrm.common.DeleteFlag;
import com.brycen.hrm.model.Profile;
import com.brycen.hrm.model.response.*;
import com.brycen.hrm.repository.ProfileRepository;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository profileRepository;
	@Autowired
    private EntityManager em;
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
	// Filter all
		public ResponseEntity<List<Profile>> filterAll(String fullname, Long skillId,Long departmentId)
		{
		    // Create flags use check all field
			boolean flag = false;
			
	        StringBuilder sqlQuery = new StringBuilder();
	        // Append query Table Profile
	        sqlQuery.append("SELECT * FROM profile p " + System.lineSeparator());
	        // Check skillId if a exists then append for append and join with Profile_Skill
	        if (skillId != 0) {
	            sqlQuery.append("LEFT JOIN profile_skill ps " + System.lineSeparator());
	            sqlQuery.append("ON p.profile_id = ps.profile_id " + System.lineSeparator());
	        }
	        
	        // Check skillId, fullname ,departmentId have exists if occur in one of the cases then continue query by condition
	        if (!fullname.equals("") || skillId != 0 || departmentId != 0) {
	        	sqlQuery.append("WHERE ");
	        }
	        // Search by fullname if fullname have exists
	        if (!fullname.equals("")) {
	            sqlQuery.append("p.full_name like '%" + fullname + "%' " + System.lineSeparator());
	            flag = true;
	        }
	        // Search by skillId if skillId have exists
	        if (skillId != 0) {
	            if (flag)
	                sqlQuery.append(" AND ");
	            sqlQuery.append("ps.skill_id =" + skillId + System.lineSeparator());
	            flag = true;
	        }
	        
	        if (departmentId != 0) {
	            if (flag)
	                sqlQuery.append(" AND ");
	            sqlQuery.append("p.department_id =" + departmentId);
	        }
	        sqlQuery.append(" AND delete_flag = 0 ");
	        System.out.println("SQL---------------------------------" + sqlQuery.toString());
	        Query q = em.createNativeQuery(sqlQuery.toString(), Profile.class);
	        List<Profile> profiles = q.getResultList();
	        return new ResponseEntity<>(profiles, HttpStatus.OK);

			
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
				p.setAddress(profile.getAddress());
				p.setStart_date(profile.getStart_date());
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
				p.setDelete_flag(DeleteFlag.YES.getNumVal());
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
