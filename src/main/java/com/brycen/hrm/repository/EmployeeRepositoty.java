package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.brycen.hrm.model.Employee;


public interface EmployeeRepositoty extends JpaRepository<Employee, Long> {
	
	@Query("select e from Employee e where e.delete_flag = 0")
	public List<Employee> findAllByFlag();
	
	@Query("select e from Role e where e.delete_flag = 0 and e.id=?1")
	public Optional<Employee> findByIdAndFlag(Long id);
}
