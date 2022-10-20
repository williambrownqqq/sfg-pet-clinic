package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "owners") // it's going to be a JPA entity mapped to the table of owners. // это будет JPA объект сопоставлен с таблицей владельцев.
public class Owner extends Person{
    // We set up column mappings. Настраиваем сопоставления столбцов.
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    //we set up a one-to-many relationship, saying that this owner every owner can have
    //multiple pets, and then we went into pets. Pets is now going to be a JPA entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") // relationship mapping
    private Set<Pet>pets = new HashSet<>();
    //when I delete something here, if I delete an owner, then that is going to cascade down.
    //So if I have pets and I delete the owner of the pet, the pets will also get
    //deleted, so that's what we want to be setting up here.

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
