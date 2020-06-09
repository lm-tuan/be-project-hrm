package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
	
	@Query("select s from Skill s where s.delete_flag = 0")
	public List<Skill> findAllByFlag();
	
	@Query("select s from Skill s where s.delete_flag = 0 and s.skill_id=?1")
	public Optional<Skill> findByIdAndFlag(Long id);
}