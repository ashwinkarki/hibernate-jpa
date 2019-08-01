package com.ashwin.jpa.hiberante.jpaapp.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    //one to many
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Review> reviewList=new ArrayList<>();



    //many to many
    @ManyToMany(mappedBy = "courses")
    private List<Student> students=new ArrayList<>();

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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReview(Review review) {
        this.reviewList.add(review);
    }

    public void removeReview(Review review) {
        this.reviewList.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudent(Student student) {
        this.students.add(student);
    }
}
