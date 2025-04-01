package com.rose.learn.jpa.hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rose.learn.jpa.hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS","In28Minutes"));
		repository.insert(new Course(2,"Learn Azure","In28Minutes"));
		repository.insert(new Course(3,"Learn DevOps","In28Minutes"));
		
		repository.deletebyId(1);
		
		System.out.println(repository.selectbyId(2).toString());
		System.out.println(repository.selectbyId(3).toString());
	}

}
