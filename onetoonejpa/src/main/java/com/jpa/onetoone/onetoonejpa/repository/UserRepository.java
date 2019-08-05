package com.jpa.onetoone.onetoonejpa.repository;


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
public class UserRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public User saveUser(User user){
        if(user.getId() == null){
            entityManager.persist(user);
        }
        else{
            entityManager.merge(user);
        }
        return user;
    }


    public List<User> findAll() {
        return entityManager.createQuery("Select u from User u",User.class).getResultList();
    }

    public void deleteuser(long l) {
        User u=findById(l);
        entityManager.remove(u);
    }

    public User findById(Long id){
        return entityManager.find(User.class,id);
    }
}
