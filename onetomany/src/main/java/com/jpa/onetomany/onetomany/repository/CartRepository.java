package com.jpa.onetomany.onetomany.repository;


import com.jpa.onetomany.onetomany.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CartRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public Cart findById(Long id){
       return entityManager.find(Cart.class,id);
    }

    public void deleteById(Long id){
        Cart c=findById(id);
        entityManager.remove(c);
    }

    public Cart save(Cart cart){
        if(cart.getId()==null){
            //inserrt
            entityManager.persist(cart);
        }
        else{
            //update
            entityManager.merge(cart);
        }

        return cart;
    }

    public List<Cart> retrieveAllCarts(){
        return entityManager.createQuery("Select c from Cart c",Cart.class).getResultList();
    }
}
