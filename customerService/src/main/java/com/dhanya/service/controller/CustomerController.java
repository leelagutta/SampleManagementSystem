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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.dhanya.service.domain.Customer;
import com.dhanya.service.repository.CustomerRepository;
import com.dhanya.service.utils.SearchCustomer;
import com.dhanya.service.utils.SearchType;

/**
 * This is the controller for customer
 * @author Leela Gutta
 *
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger log = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private MessageSender messageSender;

	/**
	 *   
	 * This is the method which handles HTTP Get request
	 * @param model holds the attribute values
	 * @return JSP page
	 *
	 */
	@RequestMapping(value = "/createCustomer", method = RequestMethod.GET)
	public String createCustomerPage(Model model) {
		model.addAttribute("customerModel", new CustomerModel());
		return "createCustomer";
	}

	/**
	 * 
	 * @param customerModelobject goes back to the client with only public properties
	 * @param bindingResult stores and exposes information about data-binding and validation errors for a specific object.
	 * @return modelandView object
	 */
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public ModelAndView createCustomerPage(@Valid CustomerModel customerModel,BindingResult bindingResult,Model model) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.info(error.getDefaultMessage());
			}
			log.info("Error while creating custoemr, returning create Customer Page");
			return new ModelAndView("createCustomer");
		}

		try {
			Customer customer = new Customer();
			customer.setFirstName(customerModel.getFirstName());
			customer.setLastName(customerModel.getLastName());
			customer.setEmail(customerModel.getEmail());
			customer.setPhone(customerModel.getPhone());
			customerRepository.create(customer);
			messageSender.sendMessage(customerModel);
            return new ModelAndView("homePage");
            
		} catch (RuntimeException ex) {
			log.error(ex.getMessage());
			if (ex.getMessage().contains("Duplicate")
					&& ex.getMessage().contains("phone_UNIQUE")) {
				customerModel.setError("Phone number already exists.");
				
			}
			return new ModelAndView("createCustomer");
		}
	}
	
	/**
	 * 
	 * @param model holds the attribute values
	 * @return JSP page
	 */
	@RequestMapping(value = "/searchCustomer.jsp", method = RequestMethod.GET)
	public ModelAndView searchCustomer(Model model) {
		return new ModelAndView("searchCustomer", "command", new CustomerModel());
	}

	/**
	 * 
	 * @param searchForm is the object that gets updated when customer enter values to search form on front end
	 * @param bindingResult stores and exposes information about data-binding and validation errors for a specific object.
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/searchCustomer.jsp", method = RequestMethod.POST)
	public ModelAndView viewCustomerResult(@Valid SearchModel searchForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				log.error(error.getDefaultMessage());
			}
			return new ModelAndView("searchCustomer");
		}

		String typeOfSearch = searchForm.getSearchType();
		String searchValue = searchForm.getSearchValue();

		SearchType searchType = SearchType.fromString(typeOfSearch);
		SearchCustomer searchCustomer = new SearchCustomer(searchType,
				searchValue);
		List<CustomerModel> customerModelList = getCustomerModelList(
				searchCustomer, model);

		if (customerModelList.isEmpty()) {
			return new ModelAndView("customerNotFound");
		} else {
			return new ModelAndView("searchCustomerResult");
		}
	}
	/**
	 *   converting the list of customer objects in to customerModel object
	 */

	public List<CustomerModel> getCustomerModelList(SearchCustomer searchCustomer, Model model) {
		
		List<Customer> customerDomainList = customerRepository.searchCustomer(searchCustomer);
		
		if (customerDomainList.isEmpty()) {
			return Collections.emptyList();
		}

		List<CustomerModel> customerModelList = new ArrayList<CustomerModel>();

		for (int i = 0; i < customerDomainList.size(); i++) {
			Customer customer = customerDomainList.get(i);
			CustomerModel customerModel = convertToModel(customer);
			customerModelList.add(customerModel);
			model.addAttribute("customerModelList", customerModelList);
		}
		return customerModelList;
	}
	
	/**
	 * 
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