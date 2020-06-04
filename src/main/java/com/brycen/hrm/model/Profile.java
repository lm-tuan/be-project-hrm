package com.brycen.hrm.model;

import java.sql.Date;
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
	@Column(name = "id")
	private Long id;
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
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * Name function: getId
	 * Parameter
	 * 
	 */
	public Long getId() {
		return id;
	}
	
	/*
	 * Name function: setId
	 * Parameter id : Long
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	 * Name function: getFullName
	 * Parameter
	 * 
	 */
	public String getFullName() {
		return fullName;
	}
	
	/*
	 * Name function: setFullName
	 * Parameter fullName: String
	 * 
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/*
	 * Name function: getIdCard
	 * Parameter
	 * 
	 */
	public int getIdCard() {
		return idCard;
	}
	
	/*
	 * Name function: setIdCard
	 * Parameter setIdCard : int
	 * 
	 */
	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}
	
	/*
	 * Name function: getBirthday
	 * Parameter
	 * 
	 */
	public Date getBirthday() {
		return birthday;
	}
	
	/*
	 * Name function: setBirthday
	 * Parameter birthday: Date
	 * 
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/*
	 * Name function: getGender
	 * Parameter
	 * 
	 */
	public int getGender() {
		return gender;
	}
	
	/*
	 * Name function: setGender
	 * Parameter gender: int
	 * 
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	/*
	 * Name function: getPhone
	 * Parameter 
	 * 
	 */
	public String getPhone() {
		return phone;
	}
	
	/*
	 * Name function: setPhone
	 * Parameter phone String
	 * 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/*
	 * Name function: getEmail
	 * Parameter
	 * 
	 */
	public String getEmail() {
		return email;
	}
	
	/*
	 * Name function: setEmail
	 * Parameter email : String
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * Name function: getPosition
	 * Parameter
	 * 
	 */
	public String getPosition() {
		return position;
	}
	
	/*
	 * Name function: setPosition
	 * Parameter position: String
	 * 
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/*
	 * Name function: getDeleteFlag
	 * Parameter
	 * 
	 */
	public int getDeleteFlag() {
		return deleteFlag;
	}
	
	/*
	 * Name function: setDeleteFlag
	 * Parameter deleteFlag: int
	 * 
	 */
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
		
}
