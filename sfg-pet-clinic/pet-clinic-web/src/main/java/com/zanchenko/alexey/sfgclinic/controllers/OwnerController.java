package com.zanchenko.alexey.sfgclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// just to clarify what i did there is i am prefixig at the class level
@RequestMapping("/owners") //Because everything in this controller is going to go to Owners, what I can do
@Controller
public class OwnerController {

    //@RequestMapping({"/owners", "/owners/index", "/owners/index.html"}) // get rid of that
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwners(){
        return "owners/index";
    }
}
