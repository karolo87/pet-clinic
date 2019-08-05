package com.petclinic.pet_clinic.domain.repository;

import com.petclinic.pet_clinic.domain.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    public List<Owner> findAllByLastNameContaining(String lastName);

}
