package com.petclinic.pet_clinic.controller;

import com.petclinic.pet_clinic.domain.model.Owner;
import com.petclinic.pet_clinic.model.FilterForm;
import com.petclinic.pet_clinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
//    @GetMapping("/delete-owner")
//    public String deleteOwner(@RequestParam("id") Long id) {
//        ownerService.deleteOwner(id);
//        return "owner/delete-owner";
//    }

    @GetMapping("/owner/delete/{id}")
    public String deleteOwner(@PathVariable("id") Long id) {
        ownerService.deleteOwner(id);
        return "owner/delete-owner";
    }

    @GetMapping("/edit-owner/{id}")
    public String editOwner(@PathVariable("id") Long id, Model model) {
        Optional<Owner> foundOwner = ownerService.findOwnerById(id);
        if (foundOwner.isPresent()) {
            model.addAttribute("editedOwner", foundOwner);
            return "owner/edit-owner";
        }
        return "redirect:/add-owner";
    }

    @PostMapping("/edit-owner")
    public String editOwnerPost(@ModelAttribute("owner") Owner owner) {
        ownerService.createOwner(owner);
        return "redirect:/owner-list";
    }

    @GetMapping("/search-by-lastname")
    public String findOwnerByLastName(Model model) {
        model.addAttribute("filterForm", new FilterForm());
        return "owner/search-by-lastname";
    }

    @PostMapping("/search-by-lastname")
    public String findOwnerByaLastNamePost(@ModelAttribute("filterForm") FilterForm filterForm,
                                           Model model) {
        List<Owner> ownerByLastName = ownerService.findOwnerByLastName(filterForm.getLastName());
        model.addAttribute("ownerList", ownerByLastName);
        return "owner/owner-list";
    }
}


