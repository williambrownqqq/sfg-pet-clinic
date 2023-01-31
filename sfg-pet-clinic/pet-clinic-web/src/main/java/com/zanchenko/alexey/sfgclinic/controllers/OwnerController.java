package com.zanchenko.alexey.sfgclinic.controllers;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

// just to clarify what i did there is i am prefixig at the class level
@RequestMapping("/owners") //Because everything in this controller is going to go to Owners, what I can do
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDTE_FROM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

//    @InitBinder // we are sending a disallowed field of ID // Why ID?
//    //ID is what drives everything in the db // ID in BaseEntity
//    public void setAllowedFields(WebDataBinder dataBinder){ // we are grabbing this WebDataBinder, so InitBinder is a standard Spring MVC annotation to allow us to have that WebDataBinder inject it into our controller and then we can take control of it.
//        dataBinder.setAllowedFields("id");
//    }
    //@RequestMapping({"/owners", "/owners/index", "/owners/index.html"}) // get rid of that

//    @RequestMapping({"", "/", "/index", "/index.html"}) // no valid already so we deleted
//    public String listOwners(Model model){
//        // we are adding the attribute of owners to that
//        int size = ownerService.findAll().size();
//        model.addAttribute("owners", ownerService.findAll()); // owners - it will be the name of property inside the model
//        // ownerService.findAll() - it is going to give us a set that will be able to iterate over. Сможет повторить
//        return "owners/index";
//    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%" ); // it's a refresher
        // underneath the covers that's gonna do SQL search and it's gonna do like a clause
        //Then the little
        //% there is a wild-card character in SQL, so that's what we're appending to the
        //String adding in a couple percent signs, and because up here, if nothing comes in, we set to an empty String and when that comes down.
        // Затем маленьки
        //% является символом подстановки в SQL, так что это то, что мы добавляем к
        //String, добавляя пару знаков процента, и потому что здесь, наверху, если ничего не приходит, мы устанавливаем на пустую Строку и когда она спускается.

        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDTE_FROM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result){
        if(result.hasErrors()){
            return VIEWS_OWNER_CREATE_OR_UPDTE_FROM;
        }
        else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDTE_FROM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result,@PathVariable Long ownerId, Model model){
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDTE_FROM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
        // What's happening here is we're going to come in, we get the ownerId bind. //Что здесь происходит: мы заходим, получаем привязку ownerId.
        //Remember we have our init binder which is preventing the Model from getting the //Помните, что у нас есть связка init, которая не позволяет модели получить значение
        //ID. So there are paths or with the form variables will all make the get //ID. Так что есть пути или с переменными формы все сделают get
        //bound to owner except for ID so that's why we need to // связанными с владельцем, за исключением ID, поэтому нам нужно
        //explicitly set it which is coming out of the path. // явно установить его, который выходит из пути.
    }
}
