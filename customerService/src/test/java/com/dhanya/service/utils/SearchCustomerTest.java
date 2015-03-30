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
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.FIRSTNAME, "xyz");
		assertNotNull(searchCustomer);
	}

	
	@Test
	public void testSearchFirstNameTypeAndValue()
	{
		String firstName ="xyz";
		SearchType searchType = SearchType.FIRSTNAME;
		
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.FIRSTNAME, "xyz");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equl",searchCustomer.getSearchValue(),firstName);
	}

	
	@Test
	public void TestSearchPhoneTypeAndValue()
	{
		String phone ="12345678";
		SearchType searchType = SearchType.PHONE;
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.PHONE, "12345678");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equal",searchCustomer.getSearchValue(),phone);
	}
	
	@Test
	public void TestSearchLasttNameTypeAndValue()
	{
		String lastName ="xyz";
		SearchType searchType = SearchType.LASTNAME;
		
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.LASTNAME, "xyz");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equl",searchCustomer.getSearchValue(),lastName);
	}

	
	@Test
	public void TestSearchEmailTypeAndValue()
	{
		String email ="xyz@gmail.com";
		SearchType searchType = SearchType.EMAIL;
		SearchCustomer searchCustomer = new SearchCustomer(SearchType.EMAIL, "xyz@gmail.com");
		assertEquals("equal",searchCustomer.getSearchType(),searchType);
		assertEquals("equal",searchCustomer.getSearchValue(),email);
	}
}