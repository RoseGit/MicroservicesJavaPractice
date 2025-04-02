package com.rose.learn.jpa.hibernate.course.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rose.learn.jpa.hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

}
