package testPackage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.hibernate.entity.Customer;
import com.hibernet.dao.CustomerDao;

public class CustomerTest {
	public static void main(String[] args) {
		Customer c =  new Customer();
		c.setName("Bill Gates");
		c.setEmail("bill@gates.com");
		
		CustomerDao dao = new CustomerDao();
		dao.store(c);
	}
	
	@Test
	public void fetchCustomer() {
		CustomerDao dao= new CustomerDao();
		Customer c = dao.fetchById(42); 
		
		assertNotNull(c);   //checking that the value is null or not		
		assertEquals("Bill Gates", c.getName());
		assertEquals("bill@gates.com", c.getEmail());
	}
	
	@Test
	public void fetchAllCustomer() {
		CustomerDao dao= new CustomerDao();
		List<Customer> c1= dao.fetchAll();
				
		System.out.println(c1.size());
		assertNotNull(c1);
		assertEquals(3, c1.size());
	}
		
}

