package com.example.hibernate;

import com.example.hibernate.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class Controller {

    private final PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Person> Profile(@RequestParam String city) {
        return repository.getPersonsByCity(city);
    }
}
