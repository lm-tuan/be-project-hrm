package com.brycen.hrm.model;

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
	private String description;
	
	
	/*
	 * Name variable: password
	 * type: String
	 * Password of user
	 * Flag delete of use
	 * deleteFlag = 0 -> user exist
	 * deleteFlag = 1 -> user was remove
	 */
	@Column(name = "deleteFlag")
	private int deleteFlag ;
	
// Relationship reference join 2 table Skill-UserSkill
	@OneToMany (mappedBy = "skill", fetch = FetchType.EAGER)
	private List<ProfileSkill> profileSkill;

	public Long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

//	public List<ProfileSkill> getProfileSkill() {
//		return profileSkill;
//	}
//
//	public void setProfileSkill(List<ProfileSkill> profileSkill) {
//		this.profileSkill = profileSkill;
//	}

	

}
