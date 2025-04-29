package com.rose.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Course services controller
 */
@RestController
public class CourseController {

	/**
	 * Simple service that returns all registered courses.
	 * @return
	 */
	@RequestMapping("/courses")
	public List<Course> retieveAllCourses() {
		return Arrays.asList(
				new Course(1,"Learn AWS", "practiceRose"),
				new Course(2,"Learn DevOps", "practiceRose"),
				new Course(3,"Learn Azure", "practiceRose")
		);
	}
}
