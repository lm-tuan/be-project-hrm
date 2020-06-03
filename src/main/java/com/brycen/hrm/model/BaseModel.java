package com.brycen.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "delete_flag")
	private boolean delete_flag ;
	
	@Column(name = "create_date")
	@CreatedDate
	private Date create_date ;
	
	@Column(name = "update_date")
	@LastModifiedDate
	private Date update_date ;
	
	@Column(name = "create_by")
	@CreatedBy
	private String create_by ;
	
	@Column(name = "update_by")
	@LastModifiedBy
	private String update_by ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(boolean delete_flag) {
		this.delete_flag = delete_flag;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	
}
