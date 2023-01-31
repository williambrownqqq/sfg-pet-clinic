package com.zanchenko.alexey.sfgclinic.controllers;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.model.PetType;
import com.zanchenko.alexey.sfgclinic.services.OwnerService;
import com.zanchenko.alexey.sfgclinic.services.PetService;
import com.zanchenko.alexey.sfgclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/owners/{ownerId}")
@Controller
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    private static final String VIEWS_PETS_CREATE_OR_UPDTE_FROM = "pets/createOrUpdatePetsForm";

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }
    // As we're working with controller methods inside the PetController, we're going to
    //want petTypes all the time and then we're going to want the Owner object all
    //the time. So, rather than having to repeat these operations and each controller
    //method, now Spring MVC is going to provide that to us.
    @ModelAttribute("types") // What this is going to do is we're going to get a Collection of PetType to types.
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("Id");
    }
}
