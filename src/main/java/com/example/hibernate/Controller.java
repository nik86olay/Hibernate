package com.example.hibernate;

import com.example.hibernate.Repository.PersonRepository;
import com.example.hibernate.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class Controller {

    PersonRepository repository;

    @Transactional
    @PostAuthorize("hasRole ('DELETE') or hasRole('WRITE')")
    @GetMapping("/persons/by-city")
    public List<Person> Profile(@RequestParam String city) {
        return repository.findPersonByCityOfLiving(city);
    }

    @Transactional
    @Secured({"ROLE_READ"})
    @GetMapping("/persons/by-age")
    public List<Person> Profile(@RequestParam int age) {
        return repository.findPersonByAgeLessThanOrderByAge(age);
    }

    @Transactional
    @PreAuthorize("#name == authentication.principal.username")
    @GetMapping("/persons/by-nameAndSurname")
    public Optional<Person> Profile(@RequestParam String name, @RequestParam String surname) {
        return repository.findPersonByNameAndSurname(name, surname);
    }

    @Transactional
    @GetMapping("/persons/by-all")
    @RolesAllowed({"ROLE_WRITE"})
    public String ByAll() {
        return "Hello all";
    }
}
