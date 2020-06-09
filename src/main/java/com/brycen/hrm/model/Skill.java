package com.brycen.hrm.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "skill")
public class Skill {
	
	/*
	 * Name variable:id
	 * type: Long
	 * Key primary of table role
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private Long skill_id;
	
	/*
	 * Name variable:name
	 * type: String
	 * Name of role
	 */
	@Column(name = "name")
	private String name;
	
	
	/*
	 * Name variable: password
	 * type: String
	 * Password of user
	 * Flag delete of use
	 * deleteFlag = 0 -> user exist
	 * deleteFlag = 1 -> user was remove
	 */
	@Column(name = "delete_flag")
	private int delete_flag ;
	
// Relationship reference join 2 table Skill-UserSkill
	@OneToMany (mappedBy = "skill", fetch = FetchType.EAGER)
	private List<ProfileSkill> profileSkill;
	
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

	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}



	
	

//	public List<ProfileSkill> getProfileSkill() {
//		return profileSkill;
//	}
//
//	public void setProfileSkill(List<ProfileSkill> profileSkill) {
//		this.profileSkill = profileSkill;
//	}

	

}
