package com.rose.rest.webservices.restful.web.services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rose.rest.webservices.restful.web.services.user.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
