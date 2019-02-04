package com.lti.onetomany.accountClass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="log_account")
public class LogAccount  {   

	@Id
	@GeneratedValue
	private int txno;
	
	@Temporal(TemporalType.TIMESTAMP) //temp
	private Date dateAndTime;
	
	private double amount;
	
	@Column(name="transaction_type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name="acno")   //join acno to link the parent class Account
	private Account account;         //many tx on one account

	public LogAccount() {
		super();
	}

	public int getTxno() {
		return txno;
	}

	public void setTxno(int txno) {
		this.txno = txno;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "LogAccount [txno=" + txno + ", dateAndTime=" + dateAndTime + ", amount=" + amount + ", type=" + type
				+ ", account=" + account + "]";
	}
	
	
	
}
