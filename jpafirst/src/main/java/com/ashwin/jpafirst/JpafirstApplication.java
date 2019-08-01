package com.ashwin.jpafirst;

import com.ashwin.jpafirst.model.Person;
import com.ashwin.jpafirst.reposit.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpafirstApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args)

	{
		SpringApplication.run(JpafirstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	/*	logger.info("User id is  {}",personJpaRepository.findById(2));*/

        logger.info("All users is  {}",personJpaRepository.findAllPerson());

	}

}
