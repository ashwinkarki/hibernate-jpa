package com.ashwin.jpa.hiberante.jpaapp.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    public Passport(String number) {
        this.number = number;
    }

    //one to one mapping,non owning side is declared by mappedBy
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Passport(){

        this.number=number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String name) {
        this.number = name;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", name='" + number + '\'' +
                '}';
    }
}
