package com.zanchenko.alexey.sfgclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity // has been mapped as a JPA entity
@Table(name = "owners") // it's going to be a JPA entity mapped to the table of owners. // это будет JPA объект сопоставлен с таблицей владельцев.
public class Owner extends Person{
    // So just to recap there, going back to the Owner(типо на страничку вернулись) because I have
    //an Owner that extends out a Person, which extends out the BaseEntity, I had to set
    //up chain of constructors on that, and then, I have all the properties including
    //the inherited class so id comes from the BaseEntity. firstName, last name comes
    // from the Person, Person object. So now, Person has a constructor that
    //takes an id, firstName and the Person calls the constructor of the base entity
    //and passing an id.
    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone,
                 Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets != null) { // if our Builder pattern doesn't pass something, that's not going to get overridden so that came in as a null
            this.pets = pets;
        }
    }

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

    public Pet getPet(String name){
        return getPet(name, false);
    }

    public Pet getPet(String name, boolean ignoreNew){
       name = name.toLowerCase();
       for(Pet pet : pets) {
           if(!ignoreNew || !pet.isNew()){
               String compName = pet.getName();
               compName = compName.toLowerCase();
               if(compName.equals(name)){
                   return pet;
               }
           }
       }
       return null;
    }
}
