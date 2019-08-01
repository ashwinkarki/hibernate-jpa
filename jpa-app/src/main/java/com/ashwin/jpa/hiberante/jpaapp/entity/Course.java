package com.ashwin.jpa.hiberante.jpaapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="course")
@NamedQueries(
        value={
                @NamedQuery(name="get_All_Courses",query = "Select c from Course c"),
                @NamedQuery(name="get_All_Courses_BB",query = "Select c from Course c where name like '%BB'")
        }
)

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime localDateTime;

    @CreationTimestamp
    private LocalDateTime createdDate;



    public Course(String name) {
        this.name = name;
    }

    public Course(){

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
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
