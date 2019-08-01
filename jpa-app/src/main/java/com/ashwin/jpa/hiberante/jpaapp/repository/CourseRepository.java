package com.ashwin.jpa.hiberante.jpaapp.repository;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id){
       return entityManager.find(Course.class,id);
    }

    public void deleteById(Long id){
        Course c=findById(id);
        entityManager.remove(c);
    }

    public Course save(Course course){
        if(course.getId()==null){
            //inserrt
            entityManager.persist(course);
        }
        else{
            //update
            entityManager.merge(course);
        }

        return course;
    }

    public void playWithEntityManager(){
       logger.info("play with entity manager");
       Course course=new Course("Web services in 100 steps");

        entityManager.persist(course);
       course.setName("Web services in 100 steps-updated");

       //if we use em.detach(course) then the updated part will not be saved.
        //detach and clear are same .. clear can be used instead of detach em.clear();

        //em.flush()inserts inro database
        //em.refresh() takes the lates data from database and refresh it no matter what we change in object


    }


}
