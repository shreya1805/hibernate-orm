package com.lti.onetomany.accountClass;

import java.sql.Date;

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
	
}
