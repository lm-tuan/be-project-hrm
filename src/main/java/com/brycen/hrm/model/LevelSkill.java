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
@Table(name = "level_skill")
public class LevelSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "level_id")
	private Long level_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "color_button")
	private String color_button;
	
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


	public Long getLevel_id() {
		return level_id;
	}


	public void setLevel_id(Long level_id) {
		this.level_id = level_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor_button() {
		return color_button;
	}


	public void setColor_button(String color_button) {
		this.color_button = color_button;
	}

	
		
}
