package com.ashwin.jpa.hiberante.jpaapp;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NativeQueryTest {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;

	@Test
	public void native_query_Basic() {
		List resultList=em.createNativeQuery("SELECT * from Course where id=?",Course.class)
				.setParameter(1,"9")
				.getResultList();
		logger.info("getting this Select from native query -> {}",resultList);
	}

	@Test
	public void native_query_named_parameter_Basic() {
		//we dont use question mark except we use :
		List resultList=em.createNativeQuery("SELECT * from Course where id =:id",Course.class)
				.setParameter("id","9")
				.getResultList();
		logger.info("getting this Select from native query id :id -> {}",resultList);
	}



}
