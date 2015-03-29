package org.model.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Model objects go back to the clients (web browser).
 * @author Leela Gutta
 *
 */
public class CustomerModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Please enter first name.")
	private String firstName;

	@NotEmpty(message = "Please enter last name.")
	private String lastName;

	@NotEmpty(message = "Please enter email.")
	@Email(message = "Please enter valid email.")
	private String email;

	@NotEmpty(message = "Please enter phone number.")
	private String phone;

	private String error;

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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return ""+firstName + " " +lastName + email;
	}

	

}
