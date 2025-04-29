package com.rose.learn.jpa.hibernate.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rose.learn.jpa.hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * Demonstrates the use of a repository using JPA
 */
@Repository
@Transactional
public class CourseJpaRepository {

	@Autowired
	private EntityManager entityManager;
	
	/**
	 * Allows you to register a new course
	 * @param course See {@link Course}
	 */
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	/**
	 * Obtain information about a specific course using its ID.
	 * @param id The course ID
	 * @return See {@link Course}
	 */
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	/**
	 * Delete a course using its ID
	 * @param id The course ID.
	 */
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
