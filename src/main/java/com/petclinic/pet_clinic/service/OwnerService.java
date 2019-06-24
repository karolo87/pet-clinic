package com.petclinic.pet_clinic.service;

import com.petclinic.pet_clinic.domain.Owner;
import com.petclinic.pet_clinic.domain.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;


    public Long createOwner(Owner owner) {
        return ownerRepository.save(owner).getId();
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    public Optional<Owner> findOwnerById(Long id) {
        return ownerRepository.findById(id);
    }


        //kontroler - komunikacja z przeglądarką
        //serwis - logika biznesowa
        //repository - komunikacja z baza danych
}
