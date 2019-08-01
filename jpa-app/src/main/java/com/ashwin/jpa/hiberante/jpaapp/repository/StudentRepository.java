package com.ashwin.jpa.hiberante.jpaapp.repository;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Passport;
import com.ashwin.jpa.hiberante.jpaapp.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id){
       return entityManager.find(Student.class,id);
    }

    public void deleteById(Long id){
        Student c=findById(id);
        entityManager.remove(c);
    }

    public Student save(Student student){
        if(student.getId()==null){
            //inserrt
            entityManager.persist(student);
        }
        else{
            //update
            entityManager.merge(student);
        }

        return student;
    }



    public void saveStudentWithPassword(){
        Passport passport=new Passport("z212");
        entityManager.persist(passport);
        Student s=new Student("Mike");

        s.setPassport(passport);

        entityManager.persist(s);


    }

    public void insertStudentAndCourse(Student student,Course course){
       //inserting many to many relationss
        student.setCourse(course);
       course.setStudent(student);

        entityManager.persist(student);
        entityManager.persist(course);


    }







}
