package com.brycen.hrm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.brycen.hrm.model.ProfileSkill;


public interface ProfileSkillRepository extends JpaRepository<ProfileSkill, Long> {
}