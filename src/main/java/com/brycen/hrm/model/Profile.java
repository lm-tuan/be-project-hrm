package com.brycen.hrm.model;

import java.sql.Date;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "profile")
public class Profile extends BaseModel {
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
	
	@Column(name = "delete_flag")
	private int delete_flag ;
	
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

	
	// Mapping with User
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
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
