package com.example.hibernate;

import com.example.hibernate.Repository.PersonRepository;
import com.example.hibernate.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class Controller {

    PersonRepository repository;

    @Transactional
    @GetMapping("/persons/by-city")
    public List<Person> Profile(@RequestParam String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    @Transactional
    @GetMapping("/persons/by-age")
    public List<Person> Profile(@RequestParam int age) {
        return repository.findPersonByAgeLessThanOrderByAge(age);
    }

    @Transactional
    @GetMapping("/persons/by-nameAndSurname")
    public Optional<Person> Profile(@RequestParam String name, @RequestParam String surname) {
        return repository.findPersonByNameAndSurname(name, surname);
    }

    @Transactional
    @GetMapping("/persons/by-all")
    public String ByAll() {
        return "Hello all";
    }
}
