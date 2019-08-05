package com.jpa.onetoone.onetoonejpa;

import com.jpa.onetoone.onetoonejpa.model.Address;
import com.jpa.onetoone.onetoonejpa.model.User;
import com.jpa.onetoone.onetoonejpa.repository.AddressRepository;
import com.jpa.onetoone.onetoonejpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnetoonejpaApplicationTests {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Test
	public void insert_User_and_Address() {
		User user=new User("ashwin","karki");
        User user1=userRepository.saveUser(user);

        //saving the address
	Address address=addressRepository.saveAddress(user1,new Address("kapan",0213424));
	logger.info("user is{}",user1);
	//	logger.info("address is{}",address);

	}

	@Test
	public void delete_user_and_address(){
		userRepository.deleteuser(1L);
	}



}
