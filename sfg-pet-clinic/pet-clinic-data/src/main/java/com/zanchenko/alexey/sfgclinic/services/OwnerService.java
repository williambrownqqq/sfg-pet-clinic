package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Owner;

import java.util.List;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>  {
    Owner findByLastName(String lastName);
    //  we don't have to define those anymore or see the set goes away there.
    //  we get all the methods that are implemented by the CrudService
    //  and the types are defined by the generics here that we have here.

    //and the types are defined by the generics here that we have here.
//    Owner findByID(Long id);
//    Owner save(Owner owner);
//    Set<Owner> findAll();

    List<Owner> findAllByLastNameLike(String lastName);
}
