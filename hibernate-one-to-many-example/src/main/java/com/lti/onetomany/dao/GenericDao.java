package com.lti.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.hibernate.util.JPAUtil;
import com.lti.onetomany.accountClass.Account;
import com.lti.onetomany.accountClass.LogAccount;

//Persistence Logic
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
	

	//Employee e=(Employee)dao.fetchById(Customer.class,123),
	//public Object fetchById(Class classname,Object pk){
	public <E> E fetchById(Class<E> classname, Object pk) {
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		
		EntityManager em = emf.createEntityManager();
		try {
			E e = em.find(classname, pk); //Select query
			return e;
		}finally {
			em.close();
		}
	}
	
	//Creating a Generic E and it is then mentioned inside List as List<E> to fetch the data related to the E
	public <E> List<E> fetchAll(Class<E> clazz){
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		EntityManager em= emf.createEntityManager();
		try {
			Query q= em.createQuery("select obj from" + clazz.getName() + "as obj");
			return q.getResultList();
			
		}
		finally {
			em.close();
		}
	}
}
