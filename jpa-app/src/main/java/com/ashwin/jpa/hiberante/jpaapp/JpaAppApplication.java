package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Review;
import com.ashwin.jpa.hiberante.jpaapp.entity.Student;
import com.ashwin.jpa.hiberante.jpaapp.repository.CourseRepository;
import com.ashwin.jpa.hiberante.jpaapp.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception{
		/*Course course= courseRepository.findById(1001L);
		logger.info("Course 1001 -> {}",course);


		*//*courseRepository.deleteById(1001L);*//*

		courseRepository.save(new Course("BB"));*/

		//one-to one mapping testing
		//studentRepository.saveStudentWithPassword();

		//one to many mapping hardcoded
		 //courseRepository.addHarcodedReviewsForCourse();


		 //one to many mapping in real scenario
		/* List<Review> reviewList=new ArrayList<>();
		 reviewList.add(new Review("4","All right learned"));
		 courseRepository.addReviewsForCourse(10001L,reviewList);*/

		studentRepository.insertStudentAndCourse(new Student("Bhawana"),new Course("byakaran"));

	}

}
