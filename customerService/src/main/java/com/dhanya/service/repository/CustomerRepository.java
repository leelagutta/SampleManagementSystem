package com.dhanya.service.repository;

import java.util.List;

import com.dhanya.service.domain.Customer;
import com.dhanya.service.utils.SearchCustomer;

public interface CustomerRepository {
	
	/**
	 * Add and search customer to and from repository.
	 * @param customer	Customer object to be created
	 * @author Leela Gutta
	 */
	void create(Customer customer);
	
	List<Customer> searchCustomer(SearchCustomer searchCustomer);

}
