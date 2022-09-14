package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findByID(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
