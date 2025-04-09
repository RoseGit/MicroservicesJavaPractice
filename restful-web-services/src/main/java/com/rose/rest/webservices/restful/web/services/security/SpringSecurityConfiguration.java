package com.rose.rest.webservices.restful.web.services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	//Anulamos los filterchain por default de spring security 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		/*1) ALL Request should be authenticated*/
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		/*2.- If a request is not authenticated, a web page is shown*/
		http.httpBasic(withDefaults());
		
		/*3.- Disable CSRF para Post, Put*/
		http.csrf().disable();
		
		return http.build();
	}
}
