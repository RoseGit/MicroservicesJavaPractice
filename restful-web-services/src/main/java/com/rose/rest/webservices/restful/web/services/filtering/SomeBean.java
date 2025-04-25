package com.rose.rest.webservices.restful.web.services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Se puede hacer ignore a nivel de clase especificando 
// el nombre de las propiedades que no queremos regresar en la respuesta 
// @JsonIgnoreProperties({"field1", "field2"})

/***
 * Using a bean with annotations and properties 
 * that are not returned in the response.
 */
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String filed1;
	//@JsonIgnore	
	private String filed2;
	private String filed3;
	
	/***
	 * Default constructor.
	 * @param filed1 Example simple value.
	 * @param filed2 Example simple value.
	 * @param filed3 Example simple value.
	 */
	public SomeBean(String filed1, String filed2, String filed3) {
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		this.filed3 = filed3;
	}
	
	/**
	 * Gets the value of the filed1 property.
	 * @return
	 */
	public String getFiled1() {
		return filed1;
	}
	
	/**
	 * Gets the value of the filed2 property.
	 * @return
	 */
	public String getFiled2() {
		return filed2;
	}
	
	/**
	 * Gets the value of the filed3 property.
	 * @return
	 */
	public String getFiled3() {
		return filed3;
	}
}
