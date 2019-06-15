package com.example.wbdvsu1projectserverjava.models;

import javax.persistence.Entity;

@Entity
public class Recruiter extends User {

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}	

	private Recruiter() {
		
	}
	
}