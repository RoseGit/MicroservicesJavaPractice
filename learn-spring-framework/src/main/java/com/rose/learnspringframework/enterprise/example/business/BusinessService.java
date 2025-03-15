package com.rose.learnspringframework.enterprise.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rose.learnspringframework.enterprise.example.data.DataService;

@Component
public class BusinessService{
	
	@Autowired
	private DataService dataService;
	
	public long calculateSum() {
		var data = dataService.getData();
		return data.stream().reduce(Integer::sum).get();
	}
}

