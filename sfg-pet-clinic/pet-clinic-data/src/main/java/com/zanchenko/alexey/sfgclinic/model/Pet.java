package com.zanchenko.alexey.sfgclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Builder move it to constructor
// Pet, this is going to be another one of our entities.
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        if(visits == null || visits.size() > 0) { // so I'm saying there's on our Builder pattern so if you don't set that explicitly our initialization
            this.visits = visits; //  gets wiped out so we won't have an empty HashSet. // поэтому я говорю, что в нашем шаблоне Builder, если вы не зададите это явно, наша инициализация
            //  будет стерта, так что у нас не будет пустого HashSet.
        }
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType; // We also had to set up PetType so let's come over here to PetType.

    @ManyToOne
    @JoinColumn(name = "owner_id") // so every pet is going to have an owner and we're going to map by owner ID.
    private Owner owner; // this relates back to Owner mapping (set)

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    // Of course a pet can go visit the vet multiple times, so each visit will become
    //an individual attribute of a pet.
    // Cascade type of all means that if we delete a
    //pet, the associated visit records for that pet will also get deleted by JPA.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
