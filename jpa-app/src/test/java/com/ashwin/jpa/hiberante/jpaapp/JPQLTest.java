package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Student;
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
import javax.persistence.Query;
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


	@Test
	public void jpql_courses_without_Students() {
		TypedQuery<Course> query=em.createQuery("Select c from Course c WHERE c.students is empty",
				Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Results -> {}",courseList);
	}

	@Test
	public void jpql_course_with_atleast_2_Students() {
		TypedQuery<Course> query=em.createQuery("Select c from Course c WHERE size(c.students) >=2",
				Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Results -> {}",courseList);
	}

	@Test
	public void jpql_courses_ordered_by_Students() {
		TypedQuery<Course> query=em.createQuery("Select c from Course c ORDER BY size(c.students)",
				Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Results -> {}",courseList);
	}

	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {
		TypedQuery<Student> query=em.createQuery("Select s from Student s where s.passport.number like '%3235%'",
				Student.class);
		List<Student> studentList=query.getResultList();
		logger.info("Results -> {}",studentList);
	}


	@Test
	public void inner_join() {
		Query query=em.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]> resultList=query.getResultList();
		logger.info("Result size-> {}",resultList.size());

		for(Object[] result:resultList){
			logger.info("Courses {} Students {}",result[0],result[1]);
		}
	}

	@Test
	public void left_join() {
		Query query = em.createQuery("Select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result size-> {}", resultList.size());

		for (Object[] result : resultList) {
			logger.info("Courses {} Students {}", result[0], result[1]);
		}
	}

		@Test
		public void cross_join() {
		//it doesnt look any matching
			//1,2, 1,3, cross multiplication of two table
			Query query=em.createQuery("Select c,s from Course c,Student s");
			List<Object[]> resultList=query.getResultList();
			logger.info("Result size-> {}",resultList.size());

			for(Object[] result:resultList){
				logger.info("Courses {} Students {}",result[0],result[1]);
			}
	}

}
