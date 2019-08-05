package com.jpa.onetomany.onetomany.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    @OneToMany(mappedBy = "cart")
    private List<Item> itemsList;

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void setItemsList(Item item) {
        this.itemsList.add(item);
    }

    public Cart() {
    }

    public Cart(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
