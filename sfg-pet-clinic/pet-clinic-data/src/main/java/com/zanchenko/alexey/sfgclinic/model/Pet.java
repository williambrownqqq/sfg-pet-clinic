package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Pet, this is going to be another one of our entities.
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType; // We also had to set up PetType so let's come over here to PetType.

    @ManyToOne
    @JoinColumn(name = "owner_id") // so every pet is going to have an owner and we're going to map by owner ID.
    private Owner owner; // this relates back to Owner mapping (set)

    @Column(name = "birth_date")
    private LocalDate birthDate;
    // Of course a pet can go visit the vet multiple times, so each visit will become
    //an individual attribute of a pet.
    // Cascade type of all means that if we delete a
    //pet, the associated visit records for that pet will also get deleted by JPA.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
