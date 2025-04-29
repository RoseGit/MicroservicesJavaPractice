package com.rose.learn.jpa.hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.learn.jpa.hibernate.course.Course;

/**
 * Demonstrates the use of a repository using Spring Data JPA
 */
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	/**
	 * Find information by author
	 * @param author The author's name
	 * @return See {@link Course}
	 */
	List<Course> findByAuthor(String author);
	/**
	 * Find information by course name.
	 * @param name The course name
	 * @return See {@link Course}
	 */
	List<Course> findByName(String name);
}
