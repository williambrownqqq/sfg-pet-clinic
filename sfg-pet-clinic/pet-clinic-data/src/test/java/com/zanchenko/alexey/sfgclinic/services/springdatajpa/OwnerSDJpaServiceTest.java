package com.zanchenko.alexey.sfgclinic.services.springdatajpa;

import com.zanchenko.alexey.sfgclinic.model.Owner;
import com.zanchenko.alexey.sfgclinic.repositories.OwnerRepository;
import com.zanchenko.alexey.sfgclinic.repositories.PetRepository;
import com.zanchenko.alexey.sfgclinic.repositories.PetTypRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // this sets up the JUnit 5 environment for Mockito
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Brown";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypRepository petTypRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner returnOwner;

    @BeforeEach // setting that with it BeforeEach method. What is going to do it's gonna reset that BrforeEach test method is called
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1L).build());
        returnOwnersSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet); // using Mockito when to say when findAll() is called, i want to return bck that owner set.

        Set<Owner> owners = ownerSDJpaService.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner)); // i am saying findById() and i have a match or there of anyLong()
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty()); // i am saying findById() and i have a match or there of anyLong()
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner); // when the ownerRepository save method is called, i'm gonna say any object there. i'm gonna return back my returnOwner object.

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerSDJpaService.findByLastName(any())).thenReturn(returnOwner);

        Owner brown = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, brown.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}