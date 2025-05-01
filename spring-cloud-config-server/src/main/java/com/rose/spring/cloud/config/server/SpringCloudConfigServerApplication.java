package com.rose.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Enable a project with Spring Cloud
 * limit-service, git-localconfig-repo
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	/**
	 * The main method of execution.
	 * @param args extra information that the program uses.
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}
