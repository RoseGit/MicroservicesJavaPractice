package com.rose.learnspringframework.enterprise.example.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rose.learnspringframework.enterprise.example.data.DataService;

/**
 * Example of a Spring managed service.
 */
@Component
public class BusinessService{
	
	private DataService dataService;
	
	/**
	 * Injection by method
	 * @param dataService See {@link DataService}
	 */
	@Autowired
	public void setDataService(DataService dataService) {
		System.out.println("Setter injection");
		this.dataService = dataService;
	}

	/**
	 * Performs the sum of the numbers managed by the service
	 * @return Sum of values
	 */
	public long calculateSum() {
		var data = dataService.getData();
		return data.stream().reduce(Integer::sum).get();
	}
}

