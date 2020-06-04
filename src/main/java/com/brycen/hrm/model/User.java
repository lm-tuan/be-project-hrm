package com.brycen.hrm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {

	/*
	 * Name variable:id
	 * type: Long
	 * Key primary of table user
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	/*
	 * Name variable:userName
	 * type: String
	 *  Account of user
	 */
	@Column(name = "username")
	private String userName;
	
	/*
	 * Name variable: password
	 * type: String
	 * Password of user
	 */
	@Column(name = "password")
	private String passWord;
	
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
	
	// Relationship reference join 2 table User-UserRole
	@OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
	private Set<UserRole> userRoles;
	
	/*
	 * Name function: getId
	 * Parameter:
	 * 
	 */
	public Long getId() {
		return id;
	}
	
	/*
	 * Name function: setId
	 * Parameter:id : Long
	 * 
	 */ 
	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	 * Name function: getUserName
	 * Parameter:
	 * 
	 */
	public String getUserName() {
		return userName;
	}
	
	/*
	 * Name function: setUserName
	 * Parameter:userName: String
	 * 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/*
	 * Name function: getPassWord
	 * Parameter:
	 * 
	 */
	public String getPassWord() {
		return passWord;
	}
	
	/*
	 * Name function: setPassWord
	 * Parameter:passWord : String
	 * 
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
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
	 * Parameter: deleteFlag: int
	 * 
	 */
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/*
	 * Name function: getUserRoles
	 * Parameter
	 * 
	 */
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	
	/*
	 * Name function: setUserRoles
	 * Parameter: userRoles: Set<UserRole>
	 * 
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
		
}