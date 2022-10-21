package com.zanchenko.alexey.sfgclinic.services.springdatajpa;

import com.zanchenko.alexey.sfgclinic.model.PetType;
import com.zanchenko.alexey.sfgclinic.repositories.PetTypRepository;
import com.zanchenko.alexey.sfgclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springjpadata")
public class PetTypeSDJpaService implements PetTypeService {
    final PetTypRepository petTypRepository;

    public PetTypeSDJpaService(PetTypRepository petTypRepository) {
        this.petTypRepository = petTypRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypRepository.deleteById(aLong);
    }
}
