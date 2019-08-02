package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.repository.CourseRepository;
import com.ashwin.jpa.hiberante.jpaapp.repository.CourseSpringDataRepository;
import javafx.scene.control.Pagination;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSpingDataRepositoryTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseSpringDataRepository repository;

    @Test
	public void find_By_Id(){
    	//optional handles null pointer excpetion
    	Optional<Course> courseOptional=repository.findById(10001L);
    	logger.info("{}",courseOptional);
	}

	@Test
	public void find_By_Id_Course_Not_Present(){
		//optional handles null pointer excpetion
		Optional<Course> courseOptional=repository.findById(500L);
		logger.info("{}",courseOptional);
	}

	@Test
	public void playing_with_CRUD_Spring_DATA(){

		logger.info("{}",repository.findAll());

		//to save new data
		repository.save(new Course("Maths"));

		logger.info("{}",repository.count());

	}


	@Test
	public void sort(){

		Sort sort=new Sort(Sort.Direction.DESC,"name");


		logger.info("Sorted Courses{}",repository.findAll(sort));

	}

	@Test
	public void pagination(){
        //first page
		PageRequest pageRequest= PageRequest.of(0,3);

		Page<Course> firstPage=repository.findAll(pageRequest);
		logger.info("Frist apge{}",firstPage.getContent());


		//2nd page
		Pageable secondPageable=firstPage.nextPageable();
		Page<Course> secondPage=repository.findAll(secondPageable);
		logger.info("Second page is {}",secondPage.getContent());

	}

	@Test
	public void find_using_name(){

		logger.info("findBy Name (Custom made) {}",repository.findByName("BB"));

	}



}
