package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brycen.hrm.model.LevelSkill;


public interface LevelSkillRepository extends JpaRepository<LevelSkill, Long> {
	
}