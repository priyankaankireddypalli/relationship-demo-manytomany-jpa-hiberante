package com.priya.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.priya.jpa.hibernate.demo.DemoApplication;
import com.priya.jpa.hibernate.demo.entity.Course;
import com.priya.jpa.hibernate.demo.entity.Passport;
import com.priya.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	//Session & session Factory - terms in hiberante
	//EntityManager & Persistence Context  - terms in jpa 
	//Transaction
	
//	@Test
//	@Transactional
//	public void someTest() {
//		//Database operation1 - Retrieve student
//		Student student = em.find(Student.class,20001L);
//		//Persistence Context(student) 
//		
//		//Database operation2 - Retrieve passport
//		Passport passport = student.getPassport();
//		//Persistence Context(student,passport) 
//		
//		//Database operation3 - update passport
//		passport.setNumber("Z123459");
//		//Persistence Context(student,passport++)
//		
//		//Database operation4 - update student
//		student.setName("Priya - Updated");
//		//Persistence Context(student++,passport++)
//	}
	@Test
	//@Transactional - is support provided by student repository // test would suceed 
	public void someTest1() {
		repository.someDummyOperationToUnderstandPersistenceContext();
	}
	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class,20001L);
		logger.info("student -- {}", student);
		logger.info("Passport details: -> {}", student.getPassport());
	}
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudentDetails() {
		Passport passport = em.find(Passport.class,40001L);
		logger.info("passport -- {}", passport);
		logger.info("student details: -> {}", passport.getStudent());
	}
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class,20001L);
		logger.info("student details -- {}", student);
		logger.info("course details: -> {}", student.getCourses());
	}
	@Test
	@Transactional
	public void retrieveCourseAndStudents() {
		Course course = em.find(Course.class,10001L);
		logger.info("course details -- {}", course);
		logger.info("student details: -> {}", course.getStudents());
	}
}
