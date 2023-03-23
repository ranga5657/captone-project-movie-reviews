package com.niranjan.springboot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.niranjan.springboot.learnjpahibernate.course.Course;
import com.niranjan.springboot.learnjpahibernate.course.jdbc.CourseJdbcRepository;
import com.niranjan.springboot.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.niranjan.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"Learn AWS in udemy","Niranjan"));
		repository.save(new Course(2,"Learn MicroServices in WiLearn","Ranga"));
		repository.save(new Course(3,"Learn Spring Boot in JavaTutorials","in28minutes"));

		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("Ranga"));
		System.out.println(repository.findByAuthor(""));
		System.out.println(repository.findByName("Learn Spring Boot in JavaTutorials"));

		
		
		
	
		
	}

}
