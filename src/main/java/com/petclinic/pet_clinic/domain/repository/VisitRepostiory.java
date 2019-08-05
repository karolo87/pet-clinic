package com.petclinic.pet_clinic.domain.repository;

import com.petclinic.pet_clinic.domain.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepostiory extends JpaRepository<Visit, Long> {

}
