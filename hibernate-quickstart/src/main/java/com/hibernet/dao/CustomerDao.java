package com.hibernet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.hibernate.entity.Customer;
import com.hibernate.util.JPAUtil;

public class CustomerDao {

	
		//code to insert customer data in the database using ORM	
		public void store(Customer customer) {
			
			//Step1: Create /Obtain entityManagerFactory object
			EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
			
			//Step2: Create Entity Manager Object   //is my persistent object
			EntityManager em= emf.createEntityManager();
			
			
			//Step3: Start/Participate in a transaction
			EntityTransaction tx= em.getTransaction();
			tx.begin();
			
			//Now we can insert /update/delete/select whatever we want 
			
			em.persist(customer); //insert=persist method,update= merge method,delete=remove method, 
							// in this way there are different types of methods for every sql query	
							// sometimes when the database is open then the auto commit flag is set to off
			
			
			//should be in finally block
			em.close();   							//connection is closed with the database   
			//emf.close();
		}
		
		public Customer fetchById(int id) {
			EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
			
			EntityManager em = emf.createEntityManager();
			try {
				Customer c = em.find(Customer.class, id); //Select query
				return c;
			}finally {
				em.close();
			}
		}
		public List<Customer> fetchAll(){
			EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
			EntityManager em= emf.createEntityManager();
			try {
				Query q= em.createQuery("select cust from Customer as cust");//JPQL  //code= select *(cust) from ( class name)customer
				return q.getResultList();
				
			}
			finally {
				em.close();
			}
		}
	}

