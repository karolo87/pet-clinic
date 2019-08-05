package com.petclinic.pet_clinic.controller;

import com.petclinic.pet_clinic.domain.model.Pet;
import com.petclinic.pet_clinic.domain.model.Visit;
import com.petclinic.pet_clinic.service.PetService;
import com.petclinic.pet_clinic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class VisitController {

    private VisitService visitService;
    private PetService petService;

    @Autowired
    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @GetMapping("/add-visit/{petId}")
    public String addVisit(@PathVariable("petId") Long id, Model model) {
        model.addAttribute("newVisit", new Visit());
        model.addAttribute("petId", id);
        return "visit/add-visit";
    }

    @PostMapping("/add-visit/{petId}")
    public String addVisitPost(@PathVariable("petId") Long petId,
            @ModelAttribute("newVisit") Visit visit) {
        visitService.addVisit(petId, visit);
        return "redirect:/owner-list";
    }

    @GetMapping("/visits/all")
    public String getAllVisitsOfAllPets(Model model)  {
        model.addAttribute("visitList", visitService.findAllVisitsOfAllPets());
        return "pet/pet-visits";
    }

    @GetMapping("/visits/{petId}")
    public String getAllVisitsOfGivenPet(@PathVariable("petId") Long id,
                                         Model model) {
        model.addAttribute("visitList", visitService.findAllVisitsOfGivenPet(id));
        return "pet/pet-visits";
    }

    @GetMapping("/visits/edit-visit/{visitId}")
    public String editVisit(@PathVariable("visitId") Long id,
                            Model model) {
        Optional<Visit> foundVisit = visitService.findVisitById(id);
        if (foundVisit.isPresent()) {
            model.addAttribute("editedVisit", foundVisit);
            return "visit/edit-visit";
        }
        return "redirect:/visits/all";
    }

    @PostMapping("/visits/edit-visit/{visitId}")
    public String editVisitPost(@PathVariable("visitId") Long id,
            @ModelAttribute("editedVisit") Visit visit){
        Long petId = visitService.findVisitById(id).get().getPet().getId();
        visitService.addVisit(petId, visit);
        return "redirect:/visits/all";
    }
}
