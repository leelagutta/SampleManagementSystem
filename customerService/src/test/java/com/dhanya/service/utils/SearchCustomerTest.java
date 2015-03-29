package com.dhanya.service.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.dhanya.service.utils.SearchCustomer;
import com.dhanya.service.utils.SearchType;

public class SearchCustomerTest {
	
	
	@Test
	public void testSearchType()
	{
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.FIRSTNAME, "Dhanya");
		assertNotNull(searchCustomer);
	}

	
	@Test
	public void testSearchFirstNameTypeAndValue()
	{
		String firstName ="Dhanya";
		SearchType searchType = SearchType.FIRSTNAME;
		
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.FIRSTNAME, "Dhanya");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equl",searchCustomer.getSearchValue(),firstName);
	}

	
	@Test
	public void TestSearchPhoneTypeAndValue()
	{
		String phone ="9848819477";
		SearchType searchType = SearchType.PHONE;
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.PHONE, "9848819477");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equal",searchCustomer.getSearchValue(),phone);
	}
	
	@Test
	public void TestSearchLasttNameTypeAndValue()
	{
		String lastName ="Gutta";
		SearchType searchType = SearchType.LASTNAME;
		
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.LASTNAME, "Gutta");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equl",searchCustomer.getSearchValue(),lastName);
	}

	
	@Test
	public void TestSearchEmailTypeAndValue()
	{
		String email ="gutta.dhanya@gmail.com";
		SearchType searchType = SearchType.EMAIL;
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.EMAIL, "gutta.dhanya@gmail.com");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equal",searchCustomer.getSearchValue(),email);
	}
}