package com.petclinic.pet_clinic.service;

import com.petclinic.pet_clinic.domain.Pet;
import com.petclinic.pet_clinic.domain.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Long createPet(Pet pet) {
        return petRepository.save(pet).getId();
    }

    public List<Pet> getListOfPets() {
        return petRepository.findAll();
    }

}
