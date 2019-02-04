package com.lti.onetomany.service;

import java.util.Date;
import java.util.List;

import com.lti.onetomany.accountClass.Account;
import com.lti.onetomany.accountClass.LogAccount;
import com.lti.onetomany.dao.GenericDao;
import com.lti.onetomany.dao.AccountDao;

//Business logic resides here
public class AccountService {
	
	public void openAccount(String name, String type, double balance) {
		Account acc = new Account();
		acc.setName(name);
		acc.setType(type);
		acc.setBalance(balance);
		
		AccountDao dao = new AccountDao();
		dao.store(acc);
	}
	
	public void withdraw(int acno, double amount) {
		AccountDao dao = new AccountDao();
		
		Account acc = dao.fetchById(Account.class, acno);
		
		double currentBalance=acc.getBalance();
		LogAccount lac=new LogAccount();
		
		lac.setDateAndTime(new Date());
		lac.setType("withdraw");
		lac.setAmount(amount);
		lac.setAccount(acc);
		currentBalance -= lac.getAmount();
		
		acc.setBalance(currentBalance);
		dao.store(acc);
		dao.store(lac);
	}
	
	public void deposit(int acno, double amount) {
		AccountDao gd=new AccountDao();
		LogAccount lac=new LogAccount();
		Account acc=gd.fetchById(Account.class, acno);
		
		lac.setAccount(acc);
		lac.setAmount(amount);
		lac.setDateAndTime(new Date());
		lac.setType("deposit");
		
		double currentBalance = acc.getBalance();
		currentBalance +=lac.getAmount();
		acc.setBalance(currentBalance);
		gd.store(acc);
		gd.store(lac);
	
	
	}
	
	public void transfer(int fromacno, int toacno, double amount) {
		AccountDao gdao= new AccountDao();
		LogAccount lacacc1 = new LogAccount();
		LogAccount lacacc2 = new LogAccount();
		
		Account acc1= gdao.fetchById(Account.class, fromacno);
		Account acc2= gdao.fetchById(Account.class, toacno);
		
		double bal1 = acc1.getBalance();
		double bal2 = acc2.getBalance();
				
		lacacc1.setAmount(amount);
		lacacc1.setType("withdraw");
		lacacc2.setAmount(amount);
		lacacc2.setType("deposit");
		
		lacacc1.setAccount(acc1);
		lacacc2.setAccount(acc2);
		
		lacacc1.setDateAndTime(new Date());
		lacacc2.setDateAndTime(new Date());
		
		bal1 -= lacacc1.getAmount();
		bal2 += lacacc1.getAmount();
		
		acc1.setBalance(bal1);
		acc2.setBalance(bal2);
		
		gdao.store(lacacc1);
		gdao.store(lacacc2);

		gdao.store(acc1);
		gdao.store(acc2);
	
	}
	
	public List<LogAccount> miniStatement(int acno) {
		AccountDao dao = new AccountDao();
		return dao.fetchMiniStatement(acno);
	}
	
	public List<LogAccount> miniStatementByName(String name) {
		AccountDao dao = new AccountDao();
		return dao.fetchMiniStatementByName(name);
	}
	
	public List<Account> accountWithdraw(double amount, String transaction_type){
		AccountDao dao = new AccountDao();
		return dao.fetchAccounts(amount, transaction_type);
	}
	
	public double balance(int acno) {
		return 0;
	}
}
