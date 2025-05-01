package com.rose.microservices.limit.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *Main program entrance...
 *Demonstrates the use of Spring Cloud (spring-cloud-config-server)
 * and centralized configuration of APIs (git-localconfig-repo)
 */
@SpringBootApplication
public class LimitServiceApplication {

	/**
	 * The main method of execution.
	 * @param args extra information that the program uses.
	 */
	public static void main(String[] args) {
		SpringApplication.run(LimitServiceApplication.class, args);
	}

}
