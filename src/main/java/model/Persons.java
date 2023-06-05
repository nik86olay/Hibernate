package model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Persons")
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name", nullable = false, length = 40)
    private String name;


    @Column(name = "surname", nullable = false, length = 40)
    private String surname;


    @Column(name = "age", nullable = false)
    @Min(0)
    private int age;

    @Column(name = "phone_number", nullable = false, length = 40)
    private String phone_number;

    @Column(name = "city_of_living")
    private String city;

}
