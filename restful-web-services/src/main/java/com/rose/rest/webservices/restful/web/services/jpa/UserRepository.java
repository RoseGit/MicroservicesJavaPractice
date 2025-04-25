package com.rose.rest.webservices.restful.web.services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.rest.webservices.restful.web.services.user.User;

/**
 * 
 * Create a JPA repository for the User entity.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
