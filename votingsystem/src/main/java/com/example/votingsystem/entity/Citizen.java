package com.example.votingsystem.entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;



@Entity
@Table(name="Citizens")
public class Citizen {
	@Id
	@Column(name="id")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
   @Column(name="password")
   private String password;
   
	public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
	@Column(name="Citizen_name")
	private String name;

	public String getName() {
		return name;
	}
     
	@Column(name="hasvoted")
	private boolean hasVoted;
	
     @Column(name="enabled")
     private boolean enabled;
	
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isHasVoted() {
		return hasVoted;
	}

	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}

	public void setName(String name) {
		this.name = name;
	}
    public Citizen() {
    	super();
    }

	public Citizen(String id, String password, String name, boolean hasVoted, boolean enabled) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.hasVoted = hasVoted;
		this.enabled = enabled;
	}
    
	
	
	
	
}
