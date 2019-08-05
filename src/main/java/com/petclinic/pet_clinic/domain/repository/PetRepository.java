package com.petclinic.pet_clinic.domain.repository;

import com.petclinic.pet_clinic.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    public List<Pet> findAllByOwnerId(Long id);
}
