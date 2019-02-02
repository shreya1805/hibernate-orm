//when JVM terminates this program will start

package com.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {         // the class name can be anything
	private static EntityManagerFactory emf= null;
	
	static {
		emf = Persistence.createEntityManagerFactory("hibernate-oracle");
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		//when this line of code will execute, persistence.xml file will be read
		//Returning the object created above
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				emf.close();                             
			}
		});
		return emf;            										
	
	}
}