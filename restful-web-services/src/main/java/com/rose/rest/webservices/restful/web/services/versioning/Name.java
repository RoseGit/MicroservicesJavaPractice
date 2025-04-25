package com.rose.rest.webservices.restful.web.services.versioning;

/**
 * Simple Bean to demonstrate versioning in a REST API.
 */
public class Name {

	private String firstName;
	private String lastName;
	
	/**
	 * Default constructor
	 * @param firstName The name user.
	 * @param lastName The last name user.
	 */
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * @return The name user.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return The last name user.
	 */
	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
