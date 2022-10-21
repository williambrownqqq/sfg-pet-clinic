package com.zanchenko.alexey.sfgclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
// This is specialties. It has one property called description, also inherits from base entity.
@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity{
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



