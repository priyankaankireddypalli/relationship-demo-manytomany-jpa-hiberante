package com.priya.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.priya.jpa.hibernate.demo.entity.Course;
import com.priya.jpa.hibernate.demo.entity.Student;
import com.priya.jpa.hibernate.demo.repository.CourseRepository;
import com.priya.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	
	
	public void run(String... args) throws Exception {
		
		
//		studentRepository.saveStudentWithPassport();
//		Course course  = repository.findById(10001L);
//		logger.info("Course details of 10001 is {} ",course);
//		
//		//repository.deleteById(10001L);
//		repository.save(new Course("Microservices in 100 Applications"));
		//courseRepository.addHardCodedReviewsForCourse();
		
// one to many and many to one
//		List<Review> reviews = new ArrayList<>();
//		reviews.add( new Review("5", "Great Hands-on Stuff"));
//		reviews.add( new Review("5", "Hatsoff"));
//		
//		courseRepository.addReviewsForCourse(10003L, reviews);
		
//		many to many
		//studentRepository.insertHardcodedStudentAndCourse();
		studentRepository.insertStudentAndCourse(new Student("Jack"),new Course("Microservices in 100 Steps"));
	}

}
