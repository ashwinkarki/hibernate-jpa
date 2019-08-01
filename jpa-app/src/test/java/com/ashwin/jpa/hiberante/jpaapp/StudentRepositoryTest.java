package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Passport;
import com.ashwin.jpa.hiberante.jpaapp.entity.Student;
import com.ashwin.jpa.hiberante.jpaapp.repository.CourseRepository;
import com.ashwin.jpa.hiberante.jpaapp.repository.StudentRepository;
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
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	public void retrieveStudentAndPasswordDetails() {
		Student student=entityManager.find(Student.class,5L);
		logger.info("student -> {}",student);

		logger.info("passport details are ->{}",student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndStudentDetails() {
		Passport passport=entityManager.find(Passport.class,4L);
		logger.info("passport -> {}",passport);

		logger.info("passport student is ->{}",passport.getStudent());
	}


	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		//many to many mapping
		Student student= entityManager.find(Student.class,7L);
		logger.info("student is ->{}",student);

		logger.info("student course is ->{}",student.getCourses());


	}




}
