package com.lti.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.hibernate.util.JPAUtil;
import com.lti.onetomany.accountClass.LogAccount;

public class AccountDao extends GenericDao {
	public List<LogAccount>fetchMiniStatement(int acno){
		
		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		EntityManager em= emf.createEntityManager();
		try {
			Query q= em.createQuery("select lact from LogAccount as lact where lact.account.acno=:acc order by lact.dateAndTime desc");
			q.setParameter("acc", acno); //Specifying named parameter as 'acc' removing ? symbol and adding : symbol
			q.setMaxResults(5);
			
			return q.getResultList();
			
		}
		finally {
			em.close();
		}
		
	}

}
