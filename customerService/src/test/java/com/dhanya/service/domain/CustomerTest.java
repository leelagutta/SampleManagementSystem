package com.dhanya.service.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	//PUT all tests into one test method
	@Test
	public void testCustomerFirstName() {
		String name = "xyz";
		Customer one = new Customer();
		one.setFirstName("xyz");
		String name2 = one.getFirstName();
		assertEquals("equal", name, name2);
	}

	@Test
	public void testCustomerLastName() {
		String name = "xyz";
		Customer one = new Customer();
		one.setLastName("xyz");
		String name2 = one.getLastName();
		assertEquals("equal", name, name2);
	}

	@Test
	public void testCustomerEmail() {
		String emailTest = "xyz@gmail.com";
		Customer one = new Customer();
		one.setEmail("xyz@gmail.com");
		String email = one.getEmail();
		assertEquals("equal", email, emailTest);
	}

	@Test
	public void testCustomerPhone() {
		String phone = "123445";
		Customer one = new Customer();
		one.setPhone("123445");
		String phone2 = one.getPhone();
		assertEquals("equal", phone, phone2);
	}

}
