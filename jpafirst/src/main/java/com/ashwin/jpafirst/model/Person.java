package com.ashwin.jpafirst.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="person")
@NamedQuery(name="find_all_persons",query="Select p from Person p")
public class Person {


        @Id
        @GeneratedValue
        private int id;

        @Column(name="name")
        private String name;
        private String location;
        private Date dateOfBirth;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
        public Date getDateOfBirth() {
            return dateOfBirth;
        }
        public void setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
        public Person(int id, String name, String location, Date dateOfBirth) {

            this.id = id;
            this.name = name;
            this.location = location;
            this.dateOfBirth = dateOfBirth;
        }

        public Person() {

        }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
