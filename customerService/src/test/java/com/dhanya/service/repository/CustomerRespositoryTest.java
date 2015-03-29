package com.dhanya.service.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.dhanya.service.config.TestBeansConfig;
import com.dhanya.service.domain.Customer;
import com.dhanya.service.exception.DuplicateCustomerException;
import com.dhanya.service.utils.SearchCustomer;
import com.dhanya.service.utils.SearchType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { TestBeansConfig.class })
public class CustomerRespositoryTest {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		String firstname = "Dhanya"; // this data is populated in testData.sql
		String lastname = "gutta";
		String email = "gutta.dhanya@gmail.com";
		String phone = "487668662";
		Customer customer = new Customer();
		customer.setFirstName(firstname);
		customer.setLastName(lastname);
		customer.setEmail(email);
		customer.setPhone(phone);
		customerRepository.create(customer);

		SearchType searchType = SearchType.PHONE;
		SearchCustomer searchCustomer = new SearchCustomer(searchType,
				customer.getPhone());

		List<Customer> list = customerRepository.searchCustomer(searchCustomer);

		for (int i = 0; i < list.size(); i++) {
			assertEquals(phone, list.get(i).getPhone());
		}
	}

	@Test(expected = DuplicateCustomerException.class)
	public void testDuplicateCreationOfCustomer() {
		String phone = "4081939393";

		//create a new customer with some phone
		Customer firstCustomer = getSimpleTestCustomerWithDefaults();
		firstCustomer.setPhone(phone);
		customerRepository.create(firstCustomer);
		
		//create another new customer with same phone
		Customer secondCustomer = getSimpleTestCustomerWithDefaults();
		secondCustomer.setPhone(phone);
		customerRepository.create(secondCustomer);
	}
	
	@Test
	public void testSearchUserByFirstName() {
		String existingUsersfirstname = "Dhanya"; // this data is populated testData.sql
		Customer customer = new Customer();

		SearchType searchType = SearchType.FIRSTNAME;
		SearchCustomer searchCustomer = new SearchCustomer(searchType, customer.getFirstName());
		customerRepository.searchCustomer(searchCustomer);
		List<Customer> list = customerRepository.searchCustomer(searchCustomer);

		for (int i = 0; i < list.size(); i++) {
			assertEquals(existingUsersfirstname, list.get(i).getPhone());
		}
	}

	private Customer getSimpleTestCustomerWithDefaults() {
		Customer customer = new Customer();
		customer.setFirstName("test");
		customer.setLastName("test");
		customer.setEmail("test@test.com");
		return customer;
	}
}