package com.rose.rest.webservices.restful.web.services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.rest.webservices.restful.web.services.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
