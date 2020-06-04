package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.User;


public interface UserRepositoty extends JpaRepository<User, Long> {
	
	@Query("select e from User e where e.delete_flag = 0")
	public List<User> findAllByFlag();
	
	@Query("select e from User e where e.delete_flag = 0 and e.id=?1")
	public Optional<User> findByIdAndFlag(Long id);
}
