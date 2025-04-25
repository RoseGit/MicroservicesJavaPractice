package com.rose.rest.webservices.restful.web.services.versioning;

/**
 * Simple Bean to demonstrate versioning in a REST API.
 */
public class PersonV2 {

	private Name name;

	/**
	 * default constructor
	 * @param name See {@link Name}
	 */
	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	/**
	 * @return Get the user's name.
	 */
	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
	
}
