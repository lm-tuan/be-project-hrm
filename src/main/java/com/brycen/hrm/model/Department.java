package com.brycen.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private Long department_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@CreationTimestamp
	@Column(name = "create_date")
	@CreatedDate
	private Date create_date ;
	
	@UpdateTimestamp
	@Column(name = "update_date")
	// @LastModifiedDate
	private Date update_date ;
	
	@Column(name = "create_by")
	@CreatedBy
	private String create_by ;
	
	@Column(name = "update_by")
	//@LastModifiedBy
	private String update_by ;
	
	@Column(name = "delete_flag")
	private int delete_flag ;

	public int getDelete_flag() {
		return delete_flag;
	}
}
