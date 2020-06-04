package com.brycen.hrm.model;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "role")
public class Role {
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
	@Column(name = "deleteFlag")
	private int deleteFlag ;
	
	// Relationship reference join 2 table Role-UserRole
	@JsonBackReference(value = "role-user")
	@OneToMany (mappedBy = "role", fetch = FetchType.EAGER)
	private Set<UserRole> userRoles;

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
	 * Parameter: id : Long
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * Name function: getName
	 * Parameter
	 * 
	 */
	public String getName() {
		return name;
	}

	/*
	 * Name function: setName
	 * Parameter: name : String
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * Name function: getDeleteFlag
	 * Parameter: 
	 * 
	 */
	public int getDeleteFlag() {
		return deleteFlag;
	}

	/*
	 * Name function: setDeleteFlag
	 * Parameter: deleteFlag : int
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
	 * Parameter: userRoles : Set<UserRole>
	 * 
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
