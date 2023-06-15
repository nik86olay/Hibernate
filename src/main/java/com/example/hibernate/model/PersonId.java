package com.example.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class PersonId implements Serializable {

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 40)
    private String surname;

    @Column(nullable = false)
    @Min(0)
    private int age;

}
