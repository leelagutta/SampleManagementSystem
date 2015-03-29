package com.dhanya.service.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhanya.service.domain.Customer;
import com.dhanya.service.exception.DuplicateCustomerException;
import com.dhanya.service.utils.SearchCustomer;
import com.dhanya.service.utils.SearchType;

/**
 * This class implements customerRepository's methods.
 * @author Leela
 *
 */
public class CustomerRepositoryImpl implements CustomerRepository {

	private static final Logger log = Logger.getLogger(CustomerRepositoryImpl.class.getName());

	@Autowired
	private DataSource dataSource;
	
	private final String INSERT_CUSTOMER_SQL = "INSERT into customer"
			+ "(firstname, lastname, email, phone) VALUES" + "(?,?,?,?)";
	
	private final String SEARCH_CUSTOMER_SQL = "SELECT * FROM customer WHERE ";
	
	public CustomerRepositoryImpl(DataSource dataSource) { 
		this.dataSource = dataSource;
	}

	public void create(Customer customer) {	
		if(customer == null)  {
			log.error("Customer cannot be null for create");
			return;
		}
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn
					.prepareStatement(INSERT_CUSTOMER_SQL);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getEmail());
			preparedStatement.setString(4, customer.getPhone());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException ex) {
			log.error("SQL exception thrown", ex);
			if(ex instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicateCustomerException("Customer already exists with phone num: " + customer.getPhone());
			}
			throw new RuntimeException(ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					log.error("SQL exception", ex);
				}
			}
		}
	}

	public List<Customer> searchCustomer(SearchCustomer searchCustomer) {
		if(searchCustomer == null) {
			log.error("SearchCustomer param cannot be null");
			return null;
		}
		
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = null;
		Customer customer = null;

		try {
			conn = dataSource.getConnection();
			StringBuilder searchQueryBySearchType = new StringBuilder(SEARCH_CUSTOMER_SQL);
			SearchType searchType = searchCustomer.getSearchType();
			PreparedStatement preparedStatement = null;

			switch (searchType) {
			case FIRSTNAME:
				searchQueryBySearchType.append(" firstName = ? ");
				preparedStatement = conn
						.prepareStatement(searchQueryBySearchType.toString());
				preparedStatement.setString(1, searchCustomer.getSearchValue());
				break;
			case LASTNAME:
				searchQueryBySearchType.append(" lastName = ? ");
				preparedStatement = conn
						.prepareStatement(searchQueryBySearchType.toString());
				preparedStatement.setString(1, searchCustomer.getSearchValue());
				break;
			case EMAIL:
				searchQueryBySearchType.append(" email = ? ");
				preparedStatement = conn
						.prepareStatement(searchQueryBySearchType.toString());
				preparedStatement.setString(1, searchCustomer.getSearchValue());
				break;
			case PHONE:
				searchQueryBySearchType.append(" phone = ? ");
				preparedStatement = conn
						.prepareStatement(searchQueryBySearchType.toString());
				preparedStatement.setString(1, searchCustomer.getSearchValue());
				break;
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				resultSet.close();
				preparedStatement.close();
				return customerList;
			} else {
				while (resultSet.next()) {
					customer = new Customer();
					customer.setId(resultSet.getInt("id"));
					customer.setFirstName(resultSet.getString("firstName"));
					customer.setLastName(resultSet.getString("lastName"));
					customer.setEmail(resultSet.getString("email"));
					customer.setPhone(resultSet.getString("phone"));
					customerList.add(customer);
				}
				resultSet.close();
				preparedStatement.close();
				return customerList;
			}
		} catch (SQLException ex) {
			log.error("SQLException error ", ex);
			throw new RuntimeException(ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					log.error("SQLException error ", ex);
				}
			}
		}
	}

}