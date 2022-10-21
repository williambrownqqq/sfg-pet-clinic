package com.zanchenko.alexey.sfgclinic.repositories;

import com.zanchenko.alexey.sfgclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
