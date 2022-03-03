package com.priya.jpa.hibernate.demo.repository;

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


@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
class NativeQueriesTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager entityManager;
	@Test
	public void native_queries_Basic() {
		//simple query
		List resultList = entityManager.createNativeQuery("select * from Course",Course.class).getResultList();
		logger.info("select * from Course c--> {}",resultList);
		
		//named query
		//Query createNamedQuery = entityManager.createNamedQuery("query_get_all_courses");
//		[Course [name=Microservices in 100 Applications], 
//		Course [name=JPA in 50 Steps], Course [name=Spring in 50 Steps], 
//		Course [name=Spring Boot in 100 Steps]]
	}
	@Test
	public void native_queries_where() {
		//simple query
		Query query = entityManager.createNativeQuery("select * from Course where id =?",Course.class);
		query.setParameter(1,10001L);
		List resultList = query.getResultList();
		logger.info("select * from Course c--> {}",resultList);
		}
	@Test
	public void native_queries_namedparameters() {
		//simple query
		Query query = entityManager.createNativeQuery("select * from Course where id = :id",Course.class);
		query.setParameter("id",10001L);
		List resultList = query.getResultList();
		logger.info("select * from Course c--> {}",resultList);
		}
	

}
