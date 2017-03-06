package store;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Customer;

public class CustomerStoreLogicTest {

	private CustomerStoreLogic store;

	@Before
	public void setUp() {
		store = new CustomerStoreLogic();
	}

//	@Test
//	public void testRegistCustomer() {
//		Customer cus = new Customer();
//		cus.setAge(20);
//		cus.setName("ȫ�浿");
//		cus.setId("12345");
//
//		assertEquals(1, store.registCustomer(cus));
//	}

//	@Test
//	public void testSearchAll() {
//
//		assertNotNull(store.searchAll());
//		assertEquals("1234", store.searchAll().get(0).getId());
//	}
//	
	
//	@Test
//	public void updateCustomer(){
//		Customer cus = new Customer();
//		cus.setAge(30);
//		cus.setName("gotchar");
//		cus.setId("1234");
//		store.updateCustomer(cus);
//		assertEquals("gotchar", store.searchAll().get(0).getName());
//	}
	
//	@Test
//	public void deleteCustomer(){
//	int key = 1234;
//		store.deleteCustomer(key);
//		assertEquals(null, store.searchAll().get(0).getName());
//	}
	
	@Test
	public void selectById(){
		int key = 1234;
		
		store.selectById(key);
		assertEquals("ȫ�浿1", store.selectById(key).getName());
		
	}
	
	
}
