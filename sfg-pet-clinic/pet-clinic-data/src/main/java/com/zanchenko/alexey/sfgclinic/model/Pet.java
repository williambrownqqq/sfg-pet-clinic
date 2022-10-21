package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
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
