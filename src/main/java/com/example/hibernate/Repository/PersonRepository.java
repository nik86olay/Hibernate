package com.example.hibernate.Repository;

import com.example.hibernate.model.Person;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT x FROM Person x WHERE x.cityOfLiving = :city")
    List<Person> findPersonByCityOfLiving(@Param("city") String city);

    @Query("SELECT x FROM Person x WHERE x.age < :age order by x.age")
    List<Person> findPersonByAgeLessThanOrderByAge(int age);

    @Query("SELECT x FROM Person x WHERE x.name = :name and x.surname = :surname")
    Optional<Person> findPersonByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

}
