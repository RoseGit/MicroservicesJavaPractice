package com.rose.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retieveAllCourses() {
		return Arrays.asList(
				new Course(1,"Learn AWS", "practiceRose"),
				new Course(2,"Learn DevOps", "practiceRose"),
				new Course(3,"Learn Azure", "practiceRose")
		);
	}
}
