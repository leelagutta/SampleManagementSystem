package com.dhanya.service.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.model.model.CustomerModel;
import org.model.model.SearchModel;
import org.model.producer.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dhanya.service.domain.Customer;
import com.dhanya.service.exception.CustomerNotFoundException;
import com.dhanya.service.exception.InvalidInputException;
import com.dhanya.service.repository.CustomerRepository;
import com.dhanya.service.utils.SearchCustomer;
import com.dhanya.service.utils.SearchType;

/**
 * This is the controller for customer
 * @author Leela Gutta
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger log = Logger.getLogger(CustomerController.class
			.getName());

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private MessageSender messageSender;

	/**
	 * @param customerModelobject goes back to the client
	 * @param bindingResult stores and 
	 * exposes information about data-binding and
	 * validation errors for a specific object.
	 * @return json
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CustomerModel createCustomerPage(
			@RequestBody @Valid CustomerModel customerModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.info(error.getDefaultMessage());
			}
			log.info("Error while creating custoemr");
			throw new InvalidInputException(bindingResult);
		}

		Customer customer = new Customer();
		customer.setFirstName(customerModel.getFirstName());
		customer.setLastName(customerModel.getLastName());
		customer.setEmail(customerModel.getEmail());
		customer.setPhone(customerModel.getPhone());
		customerRepository.create(customer);
		messageSender.sendMessage(customerModel);
		return customerModel;

	}

	/**
	 * @param searchForm
	 *            is the object that gets updated when customer enter values to
	 *            search form on front end
	 * @param bindingResult
	 *            stores and exposes information about data-binding and
	 *            validation errors for a specific object.
	 * @return Json
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<CustomerModel> viewCustomerResult(
			@Valid SearchModel searchForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.error(error.getDefaultMessage());
			}
			throw new InvalidInputException(bindingResult);
		}

		String typeOfSearch = searchForm.getSearchType();
		String searchValue = searchForm.getSearchValue();

		SearchType searchType = SearchType.fromString(typeOfSearch);
		SearchCustomer searchCustomer = new SearchCustomer(searchType,
				searchValue);
		List<CustomerModel> customerModelList = getCustomerModelList(searchCustomer);

		if (customerModelList.isEmpty()) {
			throw new CustomerNotFoundException("Customer is not present");
		} else {
			return customerModelList;
		}
	}

	/**
	 * converting the list of customer objects in to customerModel object
	 */
	public List<CustomerModel> getCustomerModelList(
			SearchCustomer searchCustomer) {

		List<Customer> customerDomainList = customerRepository
				.searchCustomer(searchCustomer);

		if (customerDomainList.isEmpty()) {
			return Collections.emptyList();
		}

		List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();

		for (int i = 0; i < customerDomainList.size(); i++) {
			Customer customer = customerDomainList.get(i);
			CustomerModel customerModel = convertToModel(customer);
			customerModelList.add(customerModel);
		}
		return customerModelList;
	}

	/**
	 * Setting customer model objects from customer object
	 */

	private CustomerModel convertToModel(Customer customer) {
		if (customer == null) {
			return null;
		}
		CustomerModel customerModel = new CustomerModel();
		customerModel.setFirstName(customer.getFirstName());
		customerModel.setLastName(customer.getLastName());
		customerModel.setEmail(customer.getEmail());
		customerModel.setPhone(customer.getPhone());
		return customerModel;
	}
}