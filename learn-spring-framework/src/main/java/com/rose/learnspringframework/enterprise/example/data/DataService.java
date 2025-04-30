package com.rose.learnspringframework.enterprise.example.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Example of a Spring managed service.
 */
@Component
public class DataService{
	
	/**
	 * Get data from numbers
	 * @return List of integers
	 */
	public List<Integer> getData(){
		return Arrays.asList(10,20,30,40);
	}
}