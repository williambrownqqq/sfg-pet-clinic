package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.model.Pet;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {
    //now we get rid of all this code so it's actually becoming cleaner already because
    //we are getting rid of duplicated code.
    //теперь мы избавляемся от всего этого кода, так что он на самом деле уже становится чище,
    // потому что мы избавляемся от дублированного кода.
//    Pet findByID(Long id);
//    Pet save(Pet pet);
//    Set<Pet> findAll();
}
