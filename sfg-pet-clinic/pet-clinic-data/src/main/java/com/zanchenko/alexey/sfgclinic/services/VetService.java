package com.zanchenko.alexey.sfgclinic.services;

import com.zanchenko.alexey.sfgclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findByID(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
