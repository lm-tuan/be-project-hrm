package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brycen.hrm.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
