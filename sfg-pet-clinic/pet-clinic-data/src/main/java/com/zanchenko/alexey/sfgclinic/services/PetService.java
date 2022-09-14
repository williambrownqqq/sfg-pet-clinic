package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByID(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
