package com.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons", schema = "pers")
public class Person {

    @EmbeddedId
    private PersonId personId;

    @Column(name = "phone_number", nullable = false, length = 40)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 40)
    private String cityOfLiving;

}
