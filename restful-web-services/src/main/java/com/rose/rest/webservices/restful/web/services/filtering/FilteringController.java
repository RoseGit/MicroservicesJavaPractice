package com.rose.rest.webservices.restful.web.services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * Controller showing the use of property filtering.
 */
@RestController
public class FilteringController {
	
	/***
	 * Simple service that displays the filtering of properties defined in the JsonIgnore bean
	 * @return {@link SomeBean}
	 */
	@GetMapping("filtering")
	public SomeBean filtering() {
		return new SomeBean("Value 1", "Value 2", "Value 3");
	}
	
	/***
	 * Shows that property filtering can be done even on lists of objects.
	 * @return {@link SomeBean}
	 */
	@GetMapping("filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("Value 1", "Value 2", "Value 3")) ;
	}
	
	/**
	 * Shows how we can dynamically filter properties of a bean.
	 * @return {@link MappingJacksonValue}
	 */
	@GetMapping("filtering-dinamic")
	public MappingJacksonValue filteringdinamic() {
		SomeBean result = new SomeBean("Value 1", "Value 2", "Value 3");
		MappingJacksonValue mappingKacksonValue = new MappingJacksonValue(result);
		
		//name of the properties to display in the response
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1", "filed3");
		
		//name defined in bean with this @JsonFilter
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingKacksonValue.setFilters(filters );
		return mappingKacksonValue;
	}
}
