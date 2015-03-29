package com.dhanya.service.domain;

/**
 * Customer entity database object. This object should not be returned directly to the clients.
 * 
 *	@author Leela Gutta
 */
public class Customer {
    
	private Integer id;

	private String firstName;
	
	private String lastName;

	private String email;

	private String phone;

	public Customer() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
}