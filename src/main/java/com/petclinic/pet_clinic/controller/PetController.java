package com.petclinic.pet_clinic.controller;

import com.petclinic.pet_clinic.domain.model.Owner;
import com.petclinic.pet_clinic.domain.model.Pet;
import com.petclinic.pet_clinic.service.OwnerService;
import com.petclinic.pet_clinic.service.PetService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class PetController {

    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/add-pet/{ownerId}")
    public String addPet(@PathVariable("ownerId") Long id,
            Model model){
        model.addAttribute("newPet", new Pet());
        model.addAttribute("ownerId", id);
        return "pet/add-pet";
    }


    @PostMapping("/add-pet/{ownerId}")
    public String addPetPost(@PathVariable("ownerId") Long id,
            @ModelAttribute("newPet") Pet pet){
        petService.assignPetToOwner(id, pet);
        System.out.println(petService);
        return "redirect:/owner/pet-list/{ownerId}";
    }

    @GetMapping("/owner/pet-list/{id}")
    public String getAllPetsOfGivenOwner(@PathVariable("id") Long id,
                                         Model model) {
        List<Pet> allPetsOfGivenOwner = petService.getAllPetsOfGivenOwner(id);
        model.addAttribute("petList", allPetsOfGivenOwner);
        return "owner/pet-list";
    }

    @GetMapping("/edit-pet/{ownerId}/{petId}")
    public String editPet(@PathVariable("ownerId") Long ownerId,
            @PathVariable("petId") Long petId, Model model) {
        Optional<Pet> foundPet = petService.findPetById(petId);
        if (foundPet.isPresent()) {
            model.addAttribute("editedPet", foundPet);
            return "pet/edit-pet";
        }
        return "redirect:/owner-list";
    }

    @PostMapping("/edit-pet/{ownerId}/{petId}")
    public String editPetPost(@PathVariable("ownerId") Long ownerId,
            @PathVariable("petId") Long petId,
            @ModelAttribute("pet") Pet pet) {
        petService.assignPetToOwner(ownerId, pet);
        return "redirect:/owner-list";
    }


}
