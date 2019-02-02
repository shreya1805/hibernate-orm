package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="customer") // mapping this class to the database
public class Customer {
	
	@Id //primary key
	@GeneratedValue
	@Column(name="id")   // here it will understand that the value of the cid will be loaded in this column of the table
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="email", unique=true)
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
