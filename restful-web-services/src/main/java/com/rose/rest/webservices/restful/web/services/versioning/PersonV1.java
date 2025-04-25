package com.rose.rest.webservices.restful.web.services.versioning;

/**
 * Simple Bean to demonstrate versioning in a REST API.
 */
public class PersonV1 {

	private String name;

	/**
	 * Default constructor.
	 * @param name The user's name.
	 */
	public PersonV1(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return Get the user's name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + name + "]";
	}

	
	
}
