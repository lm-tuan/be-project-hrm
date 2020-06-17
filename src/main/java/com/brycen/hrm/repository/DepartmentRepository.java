package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	@Query("select d from Department d where d.delete_flag = 0")
	public List<Department> findAllByFlag();
	
	@Query("select d from Department d where d.delete_flag = 0 and d.id=?1")
	public Optional<Department> findByIdAndFlag(Long id);
}

