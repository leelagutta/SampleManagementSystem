package com.dhanya.service.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	//PUT all tests into one test method
	@Test
	public void testCustomerFirstName() {
		String name = "Dhanya";
		Customer one = new Customer();
		one.setFirstName("Dhanya");
		String name2 = one.getFirstName();
		assertEquals("equal", name, name2);
	}

	@Test
	public void testCustomerLastName() {
		String name = "Gutta";
		Customer one = new Customer();
		one.setLastName("Gutta");
		String name2 = one.getLastName();
		assertEquals("equal", name, name2);
	}

	@Test
	public void testCustomerEmail() {
		String emailTest = "gutta.dhanya@gmail.com";
		Customer one = new Customer();
		one.setEmail("gutta.dhanya@gmail.com");
		String email = one.getEmail();
		assertEquals("equal", email, emailTest);
	}

	@Test
	public void testCustomerPhone() {
		String phone = "9848819447";
		Customer one = new Customer();
		one.setPhone("9848819447");
		String phone2 = one.getPhone();
		assertEquals("equal", phone, phone2);
	}

}
