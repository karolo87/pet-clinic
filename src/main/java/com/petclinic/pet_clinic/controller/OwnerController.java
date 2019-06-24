package com.petclinic.pet_clinic.controller;

import com.petclinic.pet_clinic.domain.Owner;
import com.petclinic.pet_clinic.domain.OwnerRepository;
import com.petclinic.pet_clinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/add-owner")
    public String addNewOwner(Model model) {

        model.addAttribute("newOwner", new Owner());
        return "owner/add-owner";
    }

    @PostMapping("/add-owner")
    public String addOwnerPost(@ModelAttribute("owner") Owner owner) {
        ownerService.createOwner(owner);
        System.out.println(owner);

        return "redirect:/owner-list";
    }

    @GetMapping("/owner-list")
    public String getAllOwners(Model model) {
        model.addAttribute("ownerList", ownerService.getAllOwners());
        return "owner/owner-list";
    }

    @GetMapping("/delete-owner")
    public String deleteOwner(@RequestParam("id") Long id) {
        ownerService.deleteOwner(id);
        return "owner/delete-owner";
    }

    @GetMapping("/edit-owner")
    public String editOwner(@RequestParam("id") Long id, Model model) {
        Optional<Owner> foundOwner = ownerService.findOwnerById(id);
        if (foundOwner.isPresent()) {
            model.addAttribute("owner", foundOwner);
            return "owner/edit-owner";
        }
        return "owner/add-owner";
    }

    @PostMapping("/edit-owner")
    public String editOwnerPost(@ModelAttribute("owner") Owner owner) {
        ownerService.createOwner(owner);
        return "redirect:/owner-list";
    }
}


