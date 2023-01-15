package com.zanchenko.alexey.sfgclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
// Person is an intermediary class so it's a map superclass. // промежуточный класс
// This will never be implemented by us. We're going to inherit from it.
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private  String firstName;
    @Column(name = "last_name")
    private String lastName;
}
