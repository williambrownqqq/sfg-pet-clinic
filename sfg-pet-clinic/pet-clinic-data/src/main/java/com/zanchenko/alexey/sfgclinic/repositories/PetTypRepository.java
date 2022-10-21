package com.zanchenko.alexey.sfgclinic.repositories;

import com.zanchenko.alexey.sfgclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypRepository extends CrudRepository<PetType, Long> {
}
