package com.rose.learn.jpa.hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rose.learn.jpa.hibernate.course.jdbc.CourseJdbcRepository;
import com.rose.learn.jpa.hibernate.course.jpa.CourseJpaRepository;
import com.rose.learn.jpa.hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repositoryJdbc;
	
	@Autowired
	private CourseJpaRepository repositoryJpa;
	
	@Autowired
	private CourseSpringDataJpaRepository repositoryDataJpa;
	
	@Override
	public void run(String... args) throws Exception {
		repositoryJdbc.insert(new Course(1,"Learn AWS JDBC","In28Minutes"));
		repositoryJdbc.insert(new Course(2,"Learn Azure JDBC","In28Minutes"));
		repositoryJdbc.insert(new Course(3,"Learn DevOps JDBC","In28Minutes"));
		
		repositoryJdbc.deletebyId(1);
		
		System.out.println(repositoryJdbc.selectbyId(2).toString());
		System.out.println(repositoryJdbc.selectbyId(3).toString());
		
		repositoryJpa.insert(new Course(4,"Learn AWS JPA","In28Minutes"));
		repositoryJpa.insert(new Course(5,"Learn Azure JPA","In28Minutes"));
		repositoryJpa.insert(new Course(6,"Learn DevOps JPA","In28Minutes"));
		
		repositoryJpa.deleteById(4);
		
		System.out.println(repositoryJpa.findById(5).toString());
		System.out.println(repositoryJpa.findById(6).toString());
		
		repositoryDataJpa.save(new Course(7,"Learn AWS Spring Data JPA","In28Minutes"));
		repositoryDataJpa.save(new Course(8,"Learn Azure Spring Data JPA","In28Minutes"));
		repositoryDataJpa.save(new Course(9,"Learn DevOps Spring Data JPA","In28Minutes"));
		
		repositoryDataJpa.deleteById(7L);
		
		System.out.println(repositoryDataJpa.findById(8L).toString());
		System.out.println(repositoryDataJpa.findById(9L).toString());
		
		System.out.println(repositoryDataJpa.findByAuthor("").toString());
		System.out.println(repositoryDataJpa.findByAuthor("In28Minutes").toString());
		
		System.out.println(repositoryDataJpa.findByName("").toString());
		System.out.println(repositoryDataJpa.findByName("Learn DevOps Spring Data JPA").toString());
		
		
		
	}

}
