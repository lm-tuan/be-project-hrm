package com.brycen.hrm.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private UserRole user_role;


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


	public UserRole getUser_roles() {
		return user_role;
	}


	public void setUser_roles(UserRole user_role) {
		this.user_role = user_role;
	}

}
