package com.rose.learn.jpa.hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rose.learn.jpa.hibernate.course.jdbc.CourseJdbcRepository;
import com.rose.learn.jpa.hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Autowired
	private CourseJpaRepository repository2;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"Learn AWS JDBC","In28Minutes"));
		repository.insert(new Course(2,"Learn Azure JDBC","In28Minutes"));
		repository.insert(new Course(3,"Learn DevOps JDBC","In28Minutes"));
		
		repository.deletebyId(1);
		
		System.out.println(repository.selectbyId(2).toString());
		System.out.println(repository.selectbyId(3).toString());
		
		repository2.insert(new Course(4,"Learn AWS JPA","In28Minutes"));
		repository2.insert(new Course(5,"Learn Azure JPA","In28Minutes"));
		repository2.insert(new Course(6,"Learn DevOps JPA","In28Minutes"));
		
		repository2.deleteById(4);
		
		System.out.println(repository2.findById(5).toString());
		System.out.println(repository2.findById(6).toString());
	}

}
