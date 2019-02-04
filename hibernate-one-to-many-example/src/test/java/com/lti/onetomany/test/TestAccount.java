package com.lti.onetomany.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.lti.onetomany.accountClass.Account;
import com.lti.onetomany.accountClass.LogAccount;
import com.lti.onetomany.dao.GenericDao;
import com.lti.onetomany.service.AccountService;

public class TestAccount {
	
	@Test
	public void openAccountTest() {
		AccountService service = new AccountService();		
		service.openAccount("Shreya", "Current Account", 25000);
		service.openAccount("Sumit","Saving Account" , 35000);
}
	
	@Test
	public void withdrawAccountTest() {
		AccountService service = new AccountService();
		service.withdraw(86, 1000);
	}
	
	@Test
	public void depositAccountTest() {
		AccountService service=new AccountService();
		service.deposit(86,50000);
	}
	
	@Test 
	public void transferTest() {
		AccountService service = new AccountService();
		service.transfer(86, 90, 15000);
	}
	
	@Test
	public void miniStatementTest() {
		AccountService service = new AccountService();
		List<LogAccount> list1= service.miniStatement(86);
		System.out.println("Transaction No \t Transaction Type \t\t Date and Time \t\t\t Amount");
		for(LogAccount list: list1) {
			System.out.println(list.getTxno() + "\t\t\t\t\t" + list.getType() + "\t\t\t" + list.getDateAndTime() + "\t" + list.getAmount());
		}
	}
	
	@Test
	public void miniStatementTestByName() {
		AccountService service = new AccountService();
		List<LogAccount> list1= service.miniStatementByName("Shreya");
		System.out.println("Transaction No \t Transaction Type \t\t Date and Time \t\t\t Amount");
		for(LogAccount list: list1) {
			System.out.println(list.getTxno() + "\t\t\t\t\t" + list.getType() + "\t\t\t" + list.getDateAndTime() + "\t" + list.getAmount());
		}
	}
	
	@Test
	public void amountCheck() {
		AccountService service = new AccountService();
		List<Account> list2 = service.accountWithdraw(5000.00, "withdraw");
		System.out.println("Account No \t Account Name \t Balance \t Account Type");
		for(Account list: list2) {
			System.out.println(list.getAcno() + "\t\t\t" + list.getName() + "\t\t\t" + list.getBalance() + "\t" + list.getType());
		}
	}
}

