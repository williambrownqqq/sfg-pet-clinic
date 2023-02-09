package com.zanchenko.alexey.sfgclinic.controllers;

import com.zanchenko.alexey.sfgclinic.model.Vet;
import com.zanchenko.alexey.sfgclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping("/api/vets") // I'm using GetMapping to limit this to get requests
    public @ResponseBody Set<Vet> getVetsJson(){ //  I'm mapping it to the
        // URL of api/vets. ResponseBody is going to say I want this to be
        // formatted as JSON depending on the request type.
        // It's going to fall to to
        //JSON but I could also set up Spring to render XML as well.
        // But here we're going to default out to JSON
        return vetService.findAll();
    } //
}
