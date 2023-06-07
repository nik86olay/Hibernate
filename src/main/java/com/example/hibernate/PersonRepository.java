package com.example.hibernate;

import com.example.hibernate.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
@Component
@AllArgsConstructor
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city){
        return entityManager.createQuery("select c from Person c where c.city_of_living = :city", Person.class)
                .setParameter("city", city)
                .getResultList();
    }
}
