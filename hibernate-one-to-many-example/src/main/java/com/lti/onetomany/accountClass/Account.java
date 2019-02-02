package com.lti.onetomany.accountClass;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private int acno;
	
	private String name;
	
	@Column(name="acc_type")
	private String type;

	private double balance;
	
	@OneToMany(mappedBy="account")    //map the account of Account class created under LogAccount
	private Set<LogAccount> transaction;  //one account many tansaction
	
}
