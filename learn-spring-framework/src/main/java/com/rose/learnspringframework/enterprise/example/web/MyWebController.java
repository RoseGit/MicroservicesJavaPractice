package com.rose.learnspringframework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rose.learnspringframework.enterprise.example.business.BusinessService;

import java.util.*;

/**
 * Shows the use of injection by property.
 */
@Component
public class MyWebController {

	@Autowired
	private BusinessService businessService;
	
	/**
	 * Performs the sum of the numbers managed by the service
	 * @return Sum of values
	 */
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}
