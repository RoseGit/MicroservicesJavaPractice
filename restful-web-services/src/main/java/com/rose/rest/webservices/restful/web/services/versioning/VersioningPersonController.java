package com.rose.rest.webservices.restful.web.services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Services that show us the different uses we can have for service versioning.
 */
@RestController
public class VersioningPersonController {

	/**
	 * Returns the person's name V1
	 * @return See {@link PersonV1}
	 */
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charly");
	}
	
	/**
	 * Returns the person's name V2
	 * @return See {@link PersonV2}
	 */
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charly"));
	}
	
	/**
	 * Get the version from query params in the url
	 * @return See {@link PersonV1}
	 */
	@GetMapping(path="/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonrequestParameter() {
		return new PersonV1("Bob Charly");
	}
	
	/**
	 * Get the version from query params in the url
	 * @return See {@link PersonV2}
	 */
	@GetMapping(path="/person", params = "version=2")
	public PersonV2 getSeconfVersionOfPersonrequestParameter() {
		return new PersonV2(new Name("Bob", "Charly"));
	}

	/**
	 * Get the version from headers request
	 * @return See {@link PersonV1}
	 */
	@GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charly");
	}
	
	/**
	 * Get the version from headers request
	 * @return See {@link PersonV2}
	 */
	@GetMapping(path="/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob", "Charly"));
	}
	
	/**
	 * Get the version from headers response.
	 * @return See {@link PersonV1}
	 */
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Bob Charly");
	}
	
	/**
	 * Get the version from headers response.
	 * @return See {@link PersonV2}
	 */
	@GetMapping(path="/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charly"));
	}
}

