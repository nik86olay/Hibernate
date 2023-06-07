package com.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import javax.validation.constraints.Min;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons", schema = "pers")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false, length = 40)
    private String name;


    @Column(nullable = false, length = 40)
    private String surname;


    @Column(nullable = false)
    @Min(0)
    private int age;

    @Column(nullable = false, length = 40)
    private String phone_number;

    @Column(length = 40)
    private String city_of_living;

}
