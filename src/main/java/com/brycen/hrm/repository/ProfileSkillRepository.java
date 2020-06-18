package com.brycen.hrm.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.brycen.hrm.model.ProfileSkill;



public interface ProfileSkillRepository extends JpaRepository<ProfileSkill, Long> {
	@Modifying
	@Transactional
	@Query(value = "delete from profile_skill ps where ps.profile_id=:id", nativeQuery = true)
	public void RemoveAll(@Param("id") Long id);

}

