package com.ashwin.jpa.hiberante.jpaapp.repository;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {

     List<Course> findByName(String name);
    List<Course> findByNameAndId(String name,Long id);
    List<Course> countByNameOrderById(String name);
    List<Course> countByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);

    @Query("Select c from Course c where name LIKE '%B'")
    List<Course> courseByUsingCustomQuery();

    @Query(value = "Select * from Course c where name LIKE '%B'",nativeQuery = true)
    List<Course> courseByUsingCustomQueryUsingNativeQuery();

    @Query(name = "get_All_Courses")
    List<Course> courseByUsingCustomQueryUsingNamedQuery();


}
