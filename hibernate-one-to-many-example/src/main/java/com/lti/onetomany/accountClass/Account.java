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

	public Account() {
		super();
	}

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<LogAccount> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<LogAccount> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Account [acno=" + acno + ", name=" + name + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
}
