package com.ashwin.jpa.hiberante.jpaapp.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;

    private String description;

    @ManyToOne
    private  Course course;

    public Review(String rating,String description) {
        this.rating=rating;
        this.description = description;
    }

    public Review(){

        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + description + '\'' +
                '}';
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
