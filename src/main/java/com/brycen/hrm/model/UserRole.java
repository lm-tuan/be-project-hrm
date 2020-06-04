package com.brycen.hrm.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user_role")
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserRole {
	
	/*
	 * Name variable:id
	 * type: Long
	 * Key primary of table user_role
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	/*
	 * Name variable:userId
	 * type: Long
	 * Key primary of table user_role
	 */
	@Column(name = "userId", updatable = false, insertable = false)
	private long userId;
	
	/*
	 * Name variable:roleId
	 * type: Long
	 * Key primary of table user_role
	 */
	@Column(name = "roleId", updatable = false, insertable = false)
	private long roleId;
	
	// Relationship reference join 2 table User-UserRole
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	private User user;
	
	// Relationship reference join 2 table Role-UserRole
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId", referencedColumnName = "id")
	private Role role;
	
	/*
	 * Name function: getUser
	 * Parameter
	 * 
	 */
	public User getUser() {
		return user;
	}
	
	/*
	 * Name function: setUser
	 * Parameter: user
	 * 
	 */
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
	 * Parameter: id: Long
	 * 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	 * Name function: getUserId
	 * Parameter
	 * 
	 */
	public long getUserId() {
		return userId;
	}
	
	/*
	 * Name function: setUserId
	 * Parameter: userId : Long
	 * 
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/*
	 * Name function: getRoleId
	 * Parameter
	 * 
	 */
	public long getRoleId() {
		return roleId;
	}
	
	/*
	 * Name function: setRoleId
	 * Parameter: roleId : Long
	 * 
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	/*
	 * Name function: getRole
	 * Parameter
	 * 
	 */
	public Role getRole() {
		return role;
	}
	
	/*
	 * Name function: setRole
	 * Parameter: role : Role
	 * 
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
}
