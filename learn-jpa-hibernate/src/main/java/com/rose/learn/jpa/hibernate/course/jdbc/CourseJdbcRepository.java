package com.rose.learn.jpa.hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rose.learn.jpa.hibernate.course.Course;

/**
 * Demonstrates the use of a repository using JDBC
 */
@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY = 
			"""
			INSERT INTO COURSE (id, name, author)
			VALUES(?,?, ?);
			""";
	
	private static String DELETE_QUERY = 
			"""
			DELETE FROM  COURSE 
			WHERE ID = ? 
			""";
	
	private static String SELECT_QUERY = 
			"""
			Select * FROM  COURSE 
			WHERE ID = ? 
			""";
	
	/**
	 * Register a new course registration.
	 * @param course The entity to save.
	 */
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	/**
	 * Delete a course using its identifier
	 * @param id The course Id.
	 */
	public void deletebyId(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	/**
	 * Allows you to retrieve information using the course identifier
	 * @param id The course ID.
	 * @return See {@link Course}
	 */
	public Course selectbyId(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
