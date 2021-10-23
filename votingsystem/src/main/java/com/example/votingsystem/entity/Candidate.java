package com.example.votingsystem.entity;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Table(name="Candidates")
public class Candidate {
	
	@Id
	
	@Column(name="id")
	private long id;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="Candidate_name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Column(name="NumberOfVotes")
    private Integer numberofvotes;
    
	public Integer getNumberofvotes() {
		return numberofvotes;
	}

	public void setNumberofvotes(Integer numberofvotes) {
		this.numberofvotes = numberofvotes;
	}

	public Candidate() {
    	super();
    }

	public Candidate(long id, String name, Integer numberofvotes) {
		super();
		this.id = id;
		this.name = name;
		this.numberofvotes = numberofvotes;
	}

	
	

}