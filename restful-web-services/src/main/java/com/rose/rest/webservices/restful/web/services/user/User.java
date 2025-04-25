package com.rose.rest.webservices.restful.web.services.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * Defines the User entity and its database mapping.
 */
@Entity(name = "user_details")
public class User {
	
	/**
	 * Default constructor.
	 */
	protected User() {
	}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "Name should have at leats 2 characteres")
	@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birth Date should be in the past.")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Post> posts;
	
	/**
	 * Constructor with values.
	 * @param id The user id
	 * @param name The user's name
	 * @param birthDate The user's birthday
	 */
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	/**
	 * @return The user id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id value.
	 * @param id The value of id.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return The user's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name value.
	 * @param name The value of name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The user's birthday
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * Set the birthDate value.
	 * @param birthDate the value of birthDate.
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return User posts.
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * Set the posts value.
	 * @param posts the value of posts.
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
