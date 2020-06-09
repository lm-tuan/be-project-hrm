package com.brycen.hrm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Profile;



public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
	@Query("select p from Profile p where p.delete_flag = 0")
	public List<Profile> findAllByFlag();
	
	@Query("select p from Profile p where p.delete_flag = 0 and p.profile_id=?1")
	public Optional<Profile> findByIdAndFlag(Long id);
}