package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.repository.CourseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void jpql_Basic() {
		List resultList=em.createQuery("Select c from Course c").getResultList();
		logger.info("getting this Select c from course c -> {}",resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query=em.createQuery("Select c from Course c",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("type one Select c from course c -> {}",courseList);
	}


	@Test
	public void jpql_where() {
		TypedQuery<Course> query=em.createQuery("Select c from Course c where name like '%BB'",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("type one Select c from course c  name like '%BB-> {}",courseList);
	}

	@Test
	public void jpql_named_query() {
		List resultList=em.createNamedQuery("get_All_Courses").getResultList();
		logger.info("getting named query this Select c from course c -> {}",resultList);
	}


	@Test
	public void jpql_named_query_next() {
		List resultList=em.createNamedQuery("get_All_Courses_BB").getResultList();
		logger.info("getting named queryBB this Select c from course c -> {}",resultList);
	}

}
