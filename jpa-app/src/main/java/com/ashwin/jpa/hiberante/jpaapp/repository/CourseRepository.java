package com.ashwin.jpa.hiberante.jpaapp.repository;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

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


    //one to many mapping
    public void addHarcodedReviewsForCourse() {
        //get the course
        Course course=findById(10001L);
        logger.info("course.getReviews() -> {}",course.getReviewList());

        Review review1=new Review("5","Great hands off Pythons");
        Review review2=new Review("5","Great hands off Pythons");

        course.setReview(review1);
        review1.setCourse(course);

        course.setReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }


    //one to many mapping generic
    public void addReviewsForCourse(Long courseId, List<Review> reviewList) {
        //get the course
        Course course=findById(courseId);
        logger.info("course.getReviews() -> {}",course.getReviewList());

        for(Review review:reviewList){
            course.setReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }

    }
}
