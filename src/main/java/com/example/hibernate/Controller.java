package com.example.hibernate;

import com.example.hibernate.Repository.PersonRepository;
import com.example.hibernate.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class Controller {

    PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Person> Profile(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
