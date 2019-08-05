package com.petclinic.pet_clinic.service;

import com.petclinic.pet_clinic.domain.model.Pet;
import com.petclinic.pet_clinic.domain.model.Visit;
import com.petclinic.pet_clinic.domain.repository.VisitRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    private VisitRepostiory visitRepostiory;
    private PetService petService;

    @Autowired
    public VisitService(VisitRepostiory visitRepostiory, PetService petService) {
        this.visitRepostiory = visitRepostiory;
        this.petService = petService;
    }

    public void addVisit(Long petId, Visit visit) {
        Optional<Pet> foundPet = petService.findPetById(petId);
        foundPet.ifPresent(visit::setPet);
        visitRepostiory.save(visit);
    }

    public List<Visit> findAllVisitsOfGivenPet(Long petId) {
        Optional<Pet> foundPet = petService.findPetById(petId);
        return foundPet.get()
                .getVisits();
    }

    public List<Visit> findAllVisitsOfAllPets() {
        return visitRepostiory.findAll();
    }

    public Optional<Visit> findVisitById(Long id) {
        return visitRepostiory.findById(id);
    }
}
