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
import com.priya.jpa.hibernate.demo.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	@Test
	public void findById_Basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps",course.getName());
		logger.info("Test is RUNNING");
		
	}
	
	@Test
	@DirtiesContext
	public void deleteById_Basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
		
	}
	
	@Test
	@DirtiesContext
	public void save_Basic() {
		//get a course and update the details of it and check the value
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps",course.getName());
		
		course.setName("JPA in 50 Steps - updated");
		repository.save(course);
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - updated",course1.getName());
		
	}
//	@Test
//	@DirtiesContext
//	public void playWithEntityManager() {
//		
//		repository.playWithEntityManager();
//	}
	@Test
	@Transactional
	public void retrieveReviewssForCourse() {
		Course course = repository.findById(10001L);
		logger.info("REVIEWS FOR COURSE {} ", course.getReviews());
	
	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class,50001L);
		logger.info("REVIEWS FOR COURSE {} ", review.getCourse());
	
	}
	

}
