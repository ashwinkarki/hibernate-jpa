package com.ashwin.jpa.hiberante.jpaapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    //a student can have one passport
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;



    //many to many mapping
    @ManyToMany
    @JoinTable(name="STUDENT_COURSE",joinColumns = @JoinColumn(name="STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name="COURSE_ID"))
    private List<Course> courses=new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(){

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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }


    public List<Course> getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }
}
