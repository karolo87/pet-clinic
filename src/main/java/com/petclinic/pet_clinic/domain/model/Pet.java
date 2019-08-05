package com.petclinic.pet_clinic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Integer birthDate;
    private String type;
    @ManyToOne
    private Owner owner;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pet")
    private List<Visit> visits;

}
