package com.rose.springboot.learnspringboot;

/**
 * Simple bean with the properties of a course
 */
public class Course {

	private long id;
	private String name;
	private String author;

	/**
	 * Default constructor.
	 * @param id Course identifier.
	 * @param name Course name.
	 * @param author Course author.
	 */
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	/**
	 * @return the value of the Id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the value of the Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value of the Author
	 */
	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
