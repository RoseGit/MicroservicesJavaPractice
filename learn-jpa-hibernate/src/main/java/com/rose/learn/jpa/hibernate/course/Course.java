package com.rose.learn.jpa.hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Simple course persistence entity.
 */
@Entity(name = "course")
public class Course {

	@Id
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	/**
	 * Default constructor.
	 */
	public Course() {
	}
	
	/**
	 * Optional contructor.
	 * @param id The course id
	 * @param name the name of the course.
	 * @param author name of the course author.
	 */
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	/**
	 * @return the value of Id.
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Set the value of Id
	 * @param id the value of Id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the value of name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the value of name
	 * @param name the value of name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the value of author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Set the value of author
	 * @param author the value of author.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
