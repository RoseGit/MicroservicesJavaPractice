package com.rose.rest.webservices.restful.web.services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping("filtering")
	public SomeBean filtering() {
		return new SomeBean("Value 1", "Value 2", "Value 3");
	}
	
	@GetMapping("filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("Value 1", "Value 2", "Value 3")) ;
	}
	
	@GetMapping("filtering-dinamic")
	public MappingJacksonValue filteringdinamic() {
		SomeBean result = new SomeBean("Value 1", "Value 2", "Value 3");
		
		MappingJacksonValue mappingKacksonValue = new MappingJacksonValue(result);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1", "filed3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingKacksonValue.setFilters(filters );
		return mappingKacksonValue;
	}
}
