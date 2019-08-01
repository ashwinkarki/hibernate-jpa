package com.ashwin.jpafirst.reposit;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.ashwin.jpafirst.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PersonJpaRepository {

    //connects to Databse
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person=findById(id);

         entityManager.remove(person);
    }

    public List<Person> findAllPerson() {
        TypedQuery<Person> namedQuery= entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
    }

}
