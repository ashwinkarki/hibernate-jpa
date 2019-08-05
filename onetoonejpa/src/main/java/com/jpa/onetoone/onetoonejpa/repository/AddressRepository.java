package com.jpa.onetoone.onetoonejpa.repository;


import com.jpa.onetoone.onetoonejpa.model.Address;
import com.jpa.onetoone.onetoonejpa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public Address saveAddress(User user,Address address){

        if(address.getId() == null){
            address.setUser(user);
            entityManager.persist(address);
        }
        else{
            address.setUser(user);
            entityManager.merge(address);
        }
        return address;
    }


    public List<Address> findAll() {
      return entityManager.createQuery("Select a from Address a").getResultList();
    }
}
