package com.zanchenko.alexey.sfgclinic.repositories;

import com.zanchenko.alexey.sfgclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
