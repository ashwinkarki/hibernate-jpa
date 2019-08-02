package com.ashwin.jpa.hiberante.jpaapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",nullable = false)
    private String name;


    public Employee(String name) {
        this.name = name;
    }

    public Employee(){

        this.name=name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
