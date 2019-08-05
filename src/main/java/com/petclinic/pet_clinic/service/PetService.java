package com.petclinic.pet_clinic.service;

import com.petclinic.pet_clinic.domain.model.Owner;
import com.petclinic.pet_clinic.domain.model.Pet;
import com.petclinic.pet_clinic.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private PetRepository petRepository;
    private OwnerService ownerService;

    @Autowired
    public PetService(PetRepository petRepository, OwnerService ownerService) {
        this.petRepository = petRepository;
        this.ownerService = ownerService;
    }
//
//    public Long createNewPet(Pet pet) {
//        return petRepository.save(pet).getId();
//    }

    public List<Pet> getAllPetsOfGivenOwner(Long id) {
        return petRepository.findAllByOwnerId(id);
    }

    public void assignPetToOwner(Long ownerId, Pet pet) {
        Optional<Owner> owner = ownerService.findOwnerById(ownerId);
        owner.ifPresent(pet::setOwner);

        petRepository.save(pet);
//        Optional<Owner> foundOwner = ownerService.findOwnerById(ownerId);
//        createNewPet(pet.setOwner(foundOwner.ifPresent(owner -> {
//            owner.getPetList().add(pet);
//        })));
    }

    public Optional<Pet> findPetById(Long id) {
        return petRepository.findById(id);
    }


}
