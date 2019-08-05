package com.jpa.onetomany.onetomany.repository;


import com.jpa.onetomany.onetomany.model.Cart;
import com.jpa.onetomany.onetomany.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public Item findById(Long id){
       return entityManager.find(Item.class,id);
    }

    public void deleteById(Long id){
        Item c=findById(id);
        entityManager.remove(c);
    }

    public void save(Cart cart, List<Item> itemList){
       itemList.stream().forEach(s ->{
                   s.setCart(cart);
                   entityManager.persist(s);
    });
    }


    public List<Item> retrieveAll() {
        return entityManager.createQuery("Select i from Item i",Item.class).getResultList();
    }
}
