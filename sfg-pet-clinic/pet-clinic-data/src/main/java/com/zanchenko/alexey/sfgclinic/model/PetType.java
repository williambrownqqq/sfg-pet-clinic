package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
// PetType is oe of these root entities inherits from baseEntity
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
