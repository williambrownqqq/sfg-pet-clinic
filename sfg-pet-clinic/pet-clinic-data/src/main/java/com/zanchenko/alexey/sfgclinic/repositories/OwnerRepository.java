package com.zanchenko.alexey.sfgclinic.repositories;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
