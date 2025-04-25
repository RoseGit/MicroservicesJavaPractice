package com.rose.rest.webservices.restful.web.services.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

/**
 * Defines the Post entity and its database mapping.
 */
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer Id;
	
	@Size(min = 10)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	/**
	 * Default constructor
	 */
	public Post() {
	}
	
	/**
	 * @return The value of the id property
	 */
	public Integer getId() {
		return Id;
	}
	
	/**
	 * Set the id value.
	 * @param id the value of id.
	 */
	public void setId(Integer id) {
		Id = id;
	}
	
	/**
	 * @return The value of the description property
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set description value
	 * @param description The description value
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return The value of the user property
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set user value. 
	 * @param user The user value. 
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", description=" + description + "]";
	}	
}
