package com.jpa.onetomany.onetomany;

import com.jpa.onetomany.onetomany.model.Cart;
import com.jpa.onetomany.onetomany.model.Item;
import com.jpa.onetomany.onetomany.repository.CartRepository;
import com.jpa.onetomany.onetomany.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnetomanyApplicationTests {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void insert_Cart_with_Items() {
		Cart cart=new Cart("Yellow Cart");
      Cart cart1=  cartRepository.save(cart);

      List<Item> itemsList=new ArrayList<>();
      itemsList.add(new Item("Lays",1000L));
		itemsList.add(new Item("Fruit",10L));
		itemsList.add(new Item("Sausage",600L));
		itemsList.add(new Item("Choclate",700L));
		itemsList.add(new Item("Pringles",19L));


       itemRepository.save(cart,itemsList);


	}

}
