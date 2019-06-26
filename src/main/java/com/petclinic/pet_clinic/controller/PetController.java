package com.petclinic.pet_clinic.controller;

import com.petclinic.pet_clinic.domain.Pet;
import com.petclinic.pet_clinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PetController {

    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/add-pet")
    public String addNewPet(Model model) {
        model.addAttribute("newPet", new Pet());
        return "pet/add-pet";
    }

    @PostMapping("/add-pet")
    public String addNewPetPost(@ModelAttribute("pet") Pet pet) {
        petService.createPet(pet);
        return "redirect:/pet-list";
    }

    @GetMapping("/pet-list")
    public String getListOfPets(Model model) {
        model.addAttribute("petsList", petService.getListOfPets());
        return "pet/pet-list";
    }
}
