package com.priya.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.priya.jpa.hibernate.demo.DemoApplication;
import com.priya.jpa.hibernate.demo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	@Test
	public void jpql_Basic() {
		//simple query
		List resultList = entityManager.createQuery("select c from Course c").getResultList();
		logger.info("select c from Course c --> {}",resultList);
		
		//named query
		//Query createNamedQuery = entityManager.createNamedQuery("query_get_all_courses");
//		[Course [name=Microservices in 100 Applications], 
//		Course [name=JPA in 50 Steps], Course [name=Spring in 50 Steps], 
//		Course [name=Spring Boot in 100 Steps]]
	}
	public void jpql_typed() {
		// typed query of type Course(i expect results of Course type)
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c",Course.class);
		List<Course> result = query.getResultList();
		logger.info("select c from Course c --> {}",result);
	}
	
	public void jpql_where() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c where name like '%100 Steps'",Course.class);
		List<Course> result_where = query.getResultList();
		logger.info("select c from Course c where name like '%100 Steps' --> {}",result_where);
		
	}


}
