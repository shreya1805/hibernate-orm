package com.lti.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.hibernate.util.JPAUtil;
import com.lti.onetomany.accountClass.Account;
import com.lti.onetomany.accountClass.LogAccount;

public class GenericDao {
	public void store(Object obj) {  //depending upon whose object it is, it will call the query for that object class
		
		//Step1: Create /Obtain entityManagerFactory object
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		
		//Step2: Create Entity Manager Object   //is my persistent object
		EntityManager em= emf.createEntityManager();
		
		
		//Step3: Start/Participate in a transaction
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		
		//Now we can insert /update/delete/select whatever we want 
		
		em.merge(obj); //insert=persist method,update= merge method,delete=remove method, 
						// in this way there are different types of methods for every sql query	
						// sometimes when the database is open then the auto commit flag is set to off
		
		
		//should be in finally block
		em.close();   							//connection is closed with the database   
		//emf.close();
	}
	
	public Account fetchById(int id) {
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		
		EntityManager em = emf.createEntityManager();
		try {
			Account acc = em.find(Account.class, id); //Select query
			return acc;
		}finally {
			em.close();
		}
	}
	public List<LogAccount> fetchAll(){
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		EntityManager em= emf.createEntityManager();
		try {
			Query q= em.createQuery("select logacc from LogAccount as logacc");
			return q.getResultList();
			
		}
		finally {
			em.close();
		}
	}
}
