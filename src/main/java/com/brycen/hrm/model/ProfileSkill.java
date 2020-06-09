package com.brycen.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "profile_skill")
public class ProfileSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profile_skill")
	private long id_profile_skill;
	
	@ManyToOne 
    @JoinColumn(name = "profile_id")
	private Profile profile;	
	
	@ManyToOne 
    @JoinColumn(name = "skill_id")
	private Skill skill;
	
	@OneToOne
	@JoinColumn(name = "level_id")
	private LevelSkill level;

//	public Profile getProfile() {
//		return profile;
//	}
//
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public LevelSkill getLevel() {
		return level;
	}

	public void setLevel(LevelSkill level) {
		this.level = level;
	}
	
	public long getId_profile_skill() {
		return id_profile_skill;
	}

	public void setId_profile_skill(long id_profile_skill) {
		this.id_profile_skill = id_profile_skill;
	}


		
}
