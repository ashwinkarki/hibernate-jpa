package com.jpa.onetoone.onetoonejpa.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class User {

   @Id
   @GeneratedValue
   private Long id;

   private String username;

   private String password;

   @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
   private Address address;

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }
}
