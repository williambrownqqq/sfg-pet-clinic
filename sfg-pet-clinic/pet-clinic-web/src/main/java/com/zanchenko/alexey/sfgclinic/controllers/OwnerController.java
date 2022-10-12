package com.zanchenko.alexey.sfgclinic.controllers;

import com.zanchenko.alexey.sfgclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// just to clarify what i did there is i am prefixig at the class level
@RequestMapping("/owners") //Because everything in this controller is going to go to Owners, what I can do
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //@RequestMapping({"/owners", "/owners/index", "/owners/index.html"}) // get rid of that
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model){
        // we are adding the attribute of owners to that
        int size = ownerService.findAll().size();
        model.addAttribute("owners", ownerService.findAll()); // owners - it will be the name of property inside the model
        // ownerService.findAll() - it is going to give us a set that will be able to iterate over. Сможет повторить
        return "owners/index";
    }

    @RequestMapping({"/find"})
    public String findOwners(){
        return "notimplemented";
    }


}
