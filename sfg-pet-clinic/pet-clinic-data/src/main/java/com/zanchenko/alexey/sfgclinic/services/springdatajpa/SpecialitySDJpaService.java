package com.zanchenko.alexey.sfgclinic.services.springdatajpa;

import com.zanchenko.alexey.sfgclinic.model.Speciality;
import com.zanchenko.alexey.sfgclinic.repositories.SpeialtyRepository;
import com.zanchenko.alexey.sfgclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {
    private final SpeialtyRepository speialtyRepository;

    public SpecialitySDJpaService(SpeialtyRepository speialtyRepository) {
        this.speialtyRepository = speialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        speialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return speialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return speialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        speialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        speialtyRepository.deleteById(aLong);
    }
}
