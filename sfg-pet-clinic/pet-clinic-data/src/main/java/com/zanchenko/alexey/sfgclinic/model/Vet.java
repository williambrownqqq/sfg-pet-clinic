package com.zanchenko.alexey.sfgclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    // This is setting up a mapping between the two
    //tables and that this offer the persistence so that JPA knows how to
    //navigate between the two tables and how the relationship is actually defined at
    //the database level.
    // Это настройка сопоставления между двумя таблицы и что это обеспечивает постоянство,
    // так что JPA знает, как перемещаться между двумя таблицами и как на самом деле определяется связь в уровень базы данных.
    private Set<Speciality> specialities = new HashSet<>();
    // What this means is by default
    //anything that's a many relationship is going to be lazily initialized. When we
    //set it to eager, that means that JPA is going to try to load everything all at
    //once. By lazy initialization, which is the default, it doesn't load until it it's
    //asked for so you'll get back of that entity and the specialties would be null
    //if we did not do this.

    //Что это означает по умолчанию все, что является многими отношениями, будет лениво инициализировано.
    //Когда мы установите его на «нетерпеливый», это означает, что JPA попытается загрузить все в однажды.
    //При ленивой инициализации, которая используется по умолчанию, он не загружается до тех пор,
    //пока не будет запрошено, поэтому вы вернетесь к этой сущности,
    // и специальности будут нулевыми если бы мы этого не сделали.

    //Join table is a special table that's going to sit
    //between so the entities are going to have their own relationship but the
    //underlying database is going to have a table that's going to define IDs from
    //both sides of their relationship.
    // Присоединиться стол - это специальный стол, за которым собираются сидеть между так сущности будут
    // иметь свои собственные отношения, но базовая база данных будет иметь таблицу, которая будет определять
    // идентификаторы из обе стороны их отношений.
}


// And then, vet, we are setting up a many-to-many relationship here
//
//so that gives us some flexibility with the specialties and you can see they're
//
//in line 15, we specify a join table so that table is going to allow us to
//
//specify ID values from vets, the vet_id and specialty_id. So effectively, that
//
//table is just going to have two columns in it - vet ID and specialty ID and
//
//that's going to define the relationship between the two objects in the database.