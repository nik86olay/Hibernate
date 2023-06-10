package com.example.hibernate.Repository;

import com.example.hibernate.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByCityOfLiving(String city);
    List<Person> findByAgeLessThanOrderByAge(int age);
    Optional<Person> findByNameAndSurname(String name, String surname);

}
