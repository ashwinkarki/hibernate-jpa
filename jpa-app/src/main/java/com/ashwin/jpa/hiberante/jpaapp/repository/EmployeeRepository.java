package com.ashwin.jpa.hiberante.jpaapp.repository;

import com.ashwin.jpa.hiberante.jpaapp.entity.Course;
import com.ashwin.jpa.hiberante.jpaapp.entity.Employee;
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
public class EmployeeRepository {

    private Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EntityManager entityManager;

    //insert an employee
    public void insert(Employee employee){
        entityManager.persist(employee);
    }


    //retrieve all employee
    public List<Employee> retrieveAllEmployees(){
        return entityManager.createQuery("Select e from Employee e",Employee.class).getResultList();
    }
}
