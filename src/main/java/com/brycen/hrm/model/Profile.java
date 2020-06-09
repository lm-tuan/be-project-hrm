package com.brycen.hrm.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "profile")
public class Profile {
	/*
	 * Name variable:id
	 * type: Long
	 * Key primary of table role
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	private Long profile_id;
	/*
	 * Name variable:fullName
	 * type: String
	 * 
	 */
	@Column(name = "fullName")
	private String fullName;
	
	/*
	 * Name variable:idCard
	 * type: int
	 */
	@Column(name = "idCard")
	private int idCard;
	
	/*
	 * Name variable:birthday
	 * type: Date
	 */
	@Column(name = "birthday")
	private Date birthday;
	
	/*
	 * Name variable:gender
	 * type: int
	 */
	@Column(name = "gender")
	private int gender;
	
	/*
	 * Name variable:phone
	 * type: String
	 */
	@Column(name = "phone")
	private String phone;
	
	/*
	 * Name variable:email
	 * type: String
	 */
	@Column(name = "email")
	private String email;
	
	/*
	 * Name variable:position
	 * type: Long
	 */
	@Column(name = "position")
	private String position;
	
	/*
	 * Name variable:deleteFlag
	 * type: int
	 */
	@Column(name = "deleteFlag")
	private int deleteFlag ;
	
	// Mapping with User
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	// Relationship reference join 2 table Skill-UserSkill
	@OneToMany (mappedBy = "profile", fetch = FetchType.EAGER)
	private List<ProfileSkill> profileSkill;

	public Long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(Long profile_id) {
		this.profile_id = profile_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public List<ProfileSkill> getProfileSkill() {
		return profileSkill;
	}

	public void setProfileSkill(List<ProfileSkill> profileSkill) {
		this.profileSkill = profileSkill;
	}
	
	
		
}
