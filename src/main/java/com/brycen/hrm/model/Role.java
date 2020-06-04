package com.brycen.hrm.model;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "delete_flag")
	private int delete_flag ;
	
	
	@JsonBackReference(value = "role-user")
	@OneToMany (mappedBy = "role", fetch = FetchType.EAGER)
	private Set<UserRole> userRoles;


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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

}
