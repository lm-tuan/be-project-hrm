package com.brycen.hrm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brycen.hrm.model.ERole;
import com.brycen.hrm.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
//	@Query("select r from Role r where r.deleteFlag = 0")
//	public List<Role> findAllByFlag();
//	
//	@Query("select r from Role r where r.deleteFlag = 0 and r.id=?1")
//	public Optional<Role> findByIdAndFlag(Long id);
}
