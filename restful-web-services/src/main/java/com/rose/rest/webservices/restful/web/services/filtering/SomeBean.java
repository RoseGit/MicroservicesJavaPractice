package com.rose.rest.webservices.restful.web.services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Se puede hacer ignore a nivel de clase especificando 
// el nombre de las propiedades que no queremos regresar en la respuesta 
// @JsonIgnoreProperties({"field1", "field2"})
public class SomeBean {

	private String filed1;
	@JsonIgnore	
	private String filed2;
	private String filed3;
	
	public SomeBean(String filed1, String filed2, String filed3) {
		super();
		this.filed1 = filed1;
		this.filed2 = filed2;
		this.filed3 = filed3;
	}
	public String getFiled1() {
		return filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public String getFiled3() {
		return filed3;
	}
	
	
}
