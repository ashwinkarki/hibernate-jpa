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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseRepositoryTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void find_by_id_Basic() {
		Course course=courseRepository.findById(1001L);
		logger.info("Testing is running");
		Assert.assertEquals("JPA in 50steps",course.getName());
	}

	@Test
	@DirtiesContext
	public void save_Basic() {
		Course course=courseRepository.findById(1001L);
		logger.info("Testing is running");
		Assert.assertEquals("JPAin 1000 steps",course.getName());

		course.setName("JPAin 1000 steps");
		courseRepository.save(course);

		Course course1=courseRepository.findById(1001L);
		logger.info("Testing is running after updated");
		Assert.assertEquals("JPAin 1000 steps",course.getName());
	}

	@Test
	@DirtiesContext  //at the end of test dirtiescontext reset the data into same form
	public void deleteBy_IdBasic() {
		courseRepository.deleteById(1002L);
		Assert.assertNull(courseRepository.findById(1002L));
	}

	@Test
	@DirtiesContext  //at the end of test dirtiescontext reset the data into same form
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}

	@Test
	@DirtiesContext  //at the end of test dirtiescontext reset the data into same form
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course1=courseRepository.findById(10001L);
		logger.info("{}",course1.getReviewList());
	}



}
