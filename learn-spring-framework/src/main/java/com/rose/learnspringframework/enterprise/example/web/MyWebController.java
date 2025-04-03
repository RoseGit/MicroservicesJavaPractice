package com.rose.learnspringframework.enterprise.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rose.learnspringframework.enterprise.example.business.BusinessService;

import java.util.*;

@Component
public class MyWebController {

	@Autowired
	private BusinessService businessService;
	
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}
