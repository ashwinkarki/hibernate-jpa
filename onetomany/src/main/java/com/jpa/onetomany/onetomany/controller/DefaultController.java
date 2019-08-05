package com.jpa.onetomany.onetomany.controller;

import com.jpa.onetomany.onetomany.model.Cart;
import com.jpa.onetomany.onetomany.model.Item;
import com.jpa.onetomany.onetomany.repository.CartRepository;
import com.jpa.onetomany.onetomany.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "/carts")
    public List<Cart> getAllCart(){
        return cartRepository.retrieveAllCarts();
    }

    @GetMapping(value = "/items")
    public List<Item> getAllItems(){
        return itemRepository.retrieveAll();
    }


}
