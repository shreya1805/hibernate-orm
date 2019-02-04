package com.lti.AlbumDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.hibernate.util.JPAUtil;
import com.lti.onetomany.accountClass.LogAccount;
import com.lti.onetomany.accountClass.Songs;
import com.lti.onetomany.dao.GenericDao;

public class AlbumDao extends GenericDao {
	
	public List<Songs> fetchSong(int album_id){

		EntityManagerFactory emf= JPAUtil.getEntityManagerFactory();
		EntityManager em= emf.createEntityManager();
		
		try {
			Query q= em.createQuery("Select s from Songs as s where s.album.album_id=:son order by name");
			q.setParameter("son",album_id);
			q.setMaxResults(3);
			
			return q.getResultList();
		}
		finally {
			em.close();
		}
	}
}
