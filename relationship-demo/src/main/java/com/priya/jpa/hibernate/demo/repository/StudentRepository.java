package com.priya.jpa.hibernate.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.priya.jpa.hibernate.demo.entity.Course;
import com.priya.jpa.hibernate.demo.entity.Passport;
import com.priya.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

//	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
//	@PersistenceContext
//	EntityManager entityManager;

	// public Student findById(Long id)

	// public void deleteById(Long id) --n> delete by using id

	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}

	// public Student save(Student student) --> insert or update

	public Student save(Student student) {
		if (student.getId() == null) {
			// insert
			entityManager.persist(student);
		} else {
			// update
			entityManager.merge(student);
		}
		return student;
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		entityManager.persist(passport);

		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
	}

	// public void deleteById(Long id) --n> delete by using id
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}

	public void someDummyOperationToUnderstandPersistenceContext() {
		// Database operation1 - Retrieve student
		Student student = entityManager.find(Student.class, 20001L);
		// Persistence Context(student)

		// Database operation2 - Retrieve passport
		Passport passport = student.getPassport();
		// Persistence Context(student,passport)

		// Database operation3 - update passport
		passport.setNumber("Z123459");
		// Persistence Context(student,passport++)

		// Database operation4 - update student
		student.setName("Priya - Updated");
		// Persistence Context(student++,passport++)
	}
	
	public void insertHardcodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 Steps");
		entityManager.persist(student);
		entityManager.persist(course);
		// to persist relationship among student and course
		student.addCourse(course);
		course.addStudent(student);
		
		entityManager.persist(student);
		
	}
	
	public void insertStudentAndCourse(Student student,Course course) {
		
		
		// to persist relationship among student and course
		student.addCourse(course);
		course.addStudent(student);
		
		//persisting
		entityManager.persist(student);
		entityManager.persist(course);
		
		
	}

	
}
