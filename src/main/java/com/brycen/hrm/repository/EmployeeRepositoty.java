package com.brycen.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brycen.hrm.model.Employee;


public interface EmployeeRepositoty extends JpaRepository<Employee, Long> {
	
}
