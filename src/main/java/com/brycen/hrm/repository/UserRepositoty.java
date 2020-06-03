package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Profile;


public interface UserRepositoty extends JpaRepository<Profile, Long> {
	
	@Query("select e from User e where e.delete_flag = 0")
	public List<Profile> findAllByFlag();
	
	@Query("select e from Role e where e.delete_flag = 0 and e.id=?1")
	public Optional<Profile> findByIdAndFlag(Long id);
}
