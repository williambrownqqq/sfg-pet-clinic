package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
// Person is an intermediary class so it's a map superclass. // промежуточный класс
// This will never be implemented by us. We're going to inherit from it.
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private  String firstName;
    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
